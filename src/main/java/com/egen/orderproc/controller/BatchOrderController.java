package com.egen.orderproc.controller;

import com.egen.orderproc.model.BareOrder;
import com.egen.orderproc.model.BatchOrder;
import com.egen.orderproc.model.Update;
import com.egen.orderproc.service.BatchOrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.util.Arrays;

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
