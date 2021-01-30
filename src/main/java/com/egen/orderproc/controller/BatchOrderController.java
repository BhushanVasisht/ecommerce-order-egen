package com.egen.orderproc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(path="/api/v2")
public class BatchOrderController {

    @Autowired KafkaTemplate<String, String> kafkaTemplate;

    @RequestMapping(method = RequestMethod.POST, value = "/order", consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<String> createBatchOrders(@RequestBody String body) throws IOException {

        kafkaTemplate.send("batch-order", body);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/order/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<String> updateBatchOrders(@RequestBody String body)
    {
        kafkaTemplate.send("batch-order", body);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
