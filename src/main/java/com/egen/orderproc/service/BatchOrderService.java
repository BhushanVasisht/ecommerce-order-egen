package com.egen.orderproc.service;

import com.egen.orderproc.model.BareOrder;
import com.egen.orderproc.model.UpdateStat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class BatchOrderService {

    @Autowired private AtomicOrderService atomicOrderService;

    @KafkaListener(topics = "new-order")
    public void resolveOrders(BareOrder[] orders)
    {
        System.out.println(orders[0].toString());
    }
    
    @KafkaListener(topics = "update-order")
    public void resolveUpdates(UpdateStat[] updates)
    {
        System.out.println(updates[0].toString());
    }
}
