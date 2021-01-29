package com.egen.orderproc.service;

import com.egen.orderproc.model.*;
import com.egen.orderproc.repository.ItemRepository;
import com.egen.orderproc.repository.OrderRepository;
import com.egen.orderproc.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
public class AtomicOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Transactional
    public BareOrder getOrder(String id) throws Exception {
        Orders ord = orderRepository.findById(id).orElse(null);
        return this.convertOrdersToBare(ord);
    }

    public void persistOrder(BareOrder newOrder) throws Exception {
        if(!orderRepository.findById(newOrder.getOrder_id()).isPresent())
        {
            this.convertBareToOrders(newOrder);
        }
        else throw new DataIntegrityViolationException("Duplicate Entry found for order_id= " + newOrder.getOrder_id());
    }

    @Transactional
    void convertBareToOrders(BareOrder bareOrder)
    {
        Orders ord = new Orders(bareOrder.getOrder_id(), bareOrder.getOrder_customer_id(), bareOrder.getOrder_status(), bareOrder.getOrder_subtotal(), bareOrder.getOrder_tax(), bareOrder.getOrder_shipping_charges(), bareOrder.getOrder_total(), bareOrder.getOrder_shipping_type(), bareOrder.getOrder_shipping_addressline1(), bareOrder.getOrder_shipping_addressline2(), bareOrder.getOrder_shipping_city(), bareOrder.getOrder_shipping_state(), bareOrder.getOrder_shipping_zip());
        orderRepository.save(ord);

        for(Items item : bareOrder.getItems())
        {
            ItemSet itemset = new ItemSet(bareOrder.getOrder_id(), item.getOrder_item_name(), item.getOrder_item_qty());
            itemRepository.save(itemset);
        }

        for(BarePayment bp : bareOrder.getPayments())
        {
            Payment p = new Payment(bp.getOrder_payment_confirmation_number(), ord.getOrder_id(), ord.getOrder_customer_id(), bp.getOrder_payment_method(), Date.valueOf(bp.getOrder_payment_date()), bp.getOrder_billing_addressline1(), bp.getOrder_billing_addressline2(), bp.getOrder_billing_city(), bp.getOrder_billing_state(), bp.getOrder_billing_zip());
            paymentRepository.save(p);
        }
    }

    private BareOrder convertOrdersToBare(Orders orders) throws Exception
    {
        BareOrder bord = new BareOrder(orders.getOrder_id(), orders.getOrder_customer_id(), orders.getOrder_status(), orders.getOrder_subtotal(), orders.getOrder_tax(), orders.getOrder_shipping_charges(), orders.getOrder_total(), orders.getOrder_shipping_type(), orders.getOrder_shipping_addressline1(), orders.getOrder_shipping_addressline2(), orders.getOrder_shipping_city(), orders.getOrder_shipping_state(), orders.getOrder_shipping_zip());

        List<ItemSet> itemSets = itemRepository.findItemSetById(orders.getOrder_id());
        List<Payment> paymentSets = paymentRepository.findPaymentsById(orders.getOrder_id());

        Items[] items = new Items[itemSets.size()];

        for(int i = 0; i < items.length; ++i)
        {
            items[i] = new Items(itemSets.get(i).getOrder_item_name(), itemSets.get(i).getOrder_item_qty());
        }

        BarePayment[] barepayments = new BarePayment[paymentSets.size()];

        for(int i = 0; i < barepayments.length; ++i)
        {
            barepayments[i] = new BarePayment(paymentSets.get(i).getOrder_payment_confirmation_number(), paymentSets.get(i).getOrder_payment_method(), paymentSets.get(i).getOrder_payment_date().toString(), paymentSets.get(i).getOrder_billing_addressline1(), paymentSets.get(i).getOrder_billing_addressline2(), paymentSets.get(i).getOrder_billing_city(), paymentSets.get(i).getOrder_billing_state(), paymentSets.get(i).getOrder_billing_zip());
        }

        bord.setItems(items);
        bord.setPayments(barepayments);

        return bord;
    }

    public boolean cancelOrder(String id) {
        Orders ord = orderRepository.findById(id).orElse(null);

        if(ord != null && !ord.getOrder_status().equals("Cancelled"))
        {
            ord.setOrder_status("Cancelled");
            orderRepository.save(ord);
            return true;
        }
        return false;
    }
}
