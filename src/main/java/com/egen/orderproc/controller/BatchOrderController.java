package com.egen.orderproc.controller;

import com.egen.orderproc.model.BareOrder;
import com.egen.orderproc.model.UpdateStat;
import com.egen.orderproc.service.BatchOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/v2")
public class BatchOrderController {

    @Autowired private BatchOrderService batchOrderService;

    @RequestMapping(method = RequestMethod.POST, value = "/order", consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<String> createBatchOrders(@RequestBody BareOrder[] bareOrders)
    {
        System.out.println("Hello");
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/order/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<String> updateBatchOrders(@RequestBody UpdateStat[] batch)
    {
        for(UpdateStat upd : batch)
            System.out.println(upd.toString());

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
