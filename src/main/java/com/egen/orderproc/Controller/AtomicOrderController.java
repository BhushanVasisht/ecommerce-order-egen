package com.egen.orderproc.controller;

import com.egen.orderproc.model.BareOrder;
import com.egen.orderproc.service.AtomicOrderService;
import com.sun.tools.internal.ws.wsdl.framework.DuplicateEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(path="/api/v1")
public class AtomicOrderController {

    @Autowired private AtomicOrderService atomicOrderService;

    @RequestMapping(method = RequestMethod.GET, value = "/order/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    private BareOrder getOrderById(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response)
    {
        if(id == null || id.length() == 0)
        {
            response.setStatus(400);
            return null;
        }

        try
        {
            BareOrder bord = atomicOrderService.getOrder(id);

            if(bord == null)
            {
                response.setStatus(404);
                return bord;
            }

            response.setStatus(200);
            return bord;
        }
        catch(Exception e)
        {
            response.setStatus(404);
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/order", consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<String> createAtomicOrder(@RequestBody BareOrder newOrder) {
        try{
            atomicOrderService.persistOrder(newOrder);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        catch(DataIntegrityViolationException dive)
        {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/order/cancel/{id}")
    private ResponseEntity<String> cancelAtomicOrder(@PathVariable(value = "id") String id) {
        if(atomicOrderService.cancelOrder(id)) return ResponseEntity.status(HttpStatus.OK).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
