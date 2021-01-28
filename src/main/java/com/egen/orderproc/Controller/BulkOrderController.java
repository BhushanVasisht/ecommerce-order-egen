package com.egen.orderproc.Controller;

import com.egen.orderproc.Model.Order;
import com.egen.orderproc.Service.BulkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/v2")
public class BulkOrderController {

    @Autowired
    BulkOrderService bulkOrderService;

    @RequestMapping(method = RequestMethod.POST, value = "/order")
    private void createAtomicOrder(@RequestBody Order order)
    {

    }
}
