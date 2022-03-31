package com.cy.store.service;

import com.cy.store.entity.Address;
import com.cy.store.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Guomua
 * @Description
 * @date
 **/

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderServiceTests {
    @Autowired
    private IOrderService orderService;

    @Test
    public void create(){

        Integer[] cids={4,5};
        Order order=orderService.create(6,13,"guomua",cids);
        System.out.println(order);
    }

}
