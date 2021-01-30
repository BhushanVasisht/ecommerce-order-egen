package com.egen.orderproc;

import com.egen.orderproc.model.*;
import com.egen.orderproc.repository.OrderRepository;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.NotActiveException;

@Service
public class BatchOrderService {

    @Autowired private AtomicOrderService atomicOrderService;
    @Autowired private OrderRepository orderRepository;

    @KafkaListener(topics = "batch-order", groupId = "group_id")
    public void resolveOrders(String body) throws Exception {
        try {
            BatchOrder batchOrder = new ObjectMapper().readValue(body, BatchOrder.class);

            for (BareOrder bareOrder : batchOrder.getBatch_orders()) {
                atomicOrderService.persistOrder(bareOrder);
            }
        }
        catch (JsonMappingException jme1)
        {
            Update update = new ObjectMapper().readValue(body, Update.class);

            for(UpdateStat stat : update.getOrders())
                updateOrder(stat);
        }
    }

    @Transactional
    void updateOrder(UpdateStat update) throws NotActiveException {
        Orders ord = orderRepository.findById(update.getOrder_id()).orElse(null);
        if(ord != null)
        {
            ord.setOrder_status(update.getOrder_status());
            orderRepository.save(ord);
        }
        else throw new NotActiveException();
    }
}
