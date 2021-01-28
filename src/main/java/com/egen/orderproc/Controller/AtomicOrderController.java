package com.egen.orderproc.Controller;

import com.egen.orderproc.Exception.NoSuchIdException;
import com.egen.orderproc.Model.Order;
import com.egen.orderproc.Service.AtomicOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(path="/api/v1")
public class AtomicOrderController {

    @Autowired
    private AtomicOrderService atomicOrderService;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    private String getOrderById(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response)
    {
        try {
            int orderId = Integer.parseInt(id);
            if(orderId < 0)
            {
                throw new NoSuchIdException();
            }

            response.setStatus(200);
//            return atomicOrderService.getOrder(id).toString();
        }
        catch(Exception ignored) {
        }

        response.setStatus(404);
        return "";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/order", consumes = MediaType.APPLICATION_JSON_VALUE)
    private void createAtomicOrder(@RequestBody Order order, HttpServletRequest request, HttpServletResponse response)
    {


        response.setStatus(201);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/order/cancel")
    private void cancelAtomicOrder(HttpServletRequest request, HttpServletResponse response)
    {

    }
}
