package com.cy.store.service;

import com.cy.store.entity.Address;
import com.cy.store.entity.Order;

/**
 * @author Guomua
 * @Description
 * @date
 **/
public interface IOrderService {
    Order create(Integer aid, Integer uid, String username, Integer[]cids);


}
