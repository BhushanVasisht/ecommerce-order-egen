package com.egen.orderproc.service;

import com.egen.orderproc.AtomicOrderService;
import com.egen.orderproc.model.BareOrder;
import com.egen.orderproc.model.BarePayment;
import com.egen.orderproc.model.Items;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class AtomicOrderServiceTest {

    @Autowired private AtomicOrderService atomicOrderService;

    @Test
    public void getOrderTest()
    {
        try
        {
            BareOrder bord = atomicOrderService.getOrder("qwerg2345");
            Assert.assertNotEquals(bord, null);
        }
        catch(Exception ignored)
        {

        }
    }

    @Test
    public void persistOrderTest1() {

        Exception exception = assertThrows(Exception.class, () -> {
            BareOrder bareOrder = new BareOrder("1234", "4324567346", "New",0.0,0.0,0.0,0.0, "", "", "","","","");
            atomicOrderService.persistOrder(bareOrder);
        });

        Assert.assertTrue(exception instanceof NullPointerException);
    }

    @Test
    public void persistOrderTest2() throws Exception {

        BareOrder bareOrder = new BareOrder("1234", "4324567346", "New",0.0,0.0,0.0,0.0, "", "", "","","","");
        Items[] items = new Items[1];
        items[0] = new Items("Test", 1);
        bareOrder.setItems(items);
        BarePayment[] payments = new BarePayment[1];
        payments[0] = new BarePayment("1345678","Card", "2015-03-31", "", "","", "", "");
        bareOrder.setPayments(payments);
        atomicOrderService.persistOrder(bareOrder);

        BareOrder ord = atomicOrderService.getOrder("1234");
        Assert.assertNotNull(ord);
    }
}
