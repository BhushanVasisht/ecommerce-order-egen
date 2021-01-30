package com.egen.orderproc.service;

import com.egen.orderproc.AtomicOrderService;
import com.egen.orderproc.model.BareOrder;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
    public void persistOrderTest() {

    }
}
