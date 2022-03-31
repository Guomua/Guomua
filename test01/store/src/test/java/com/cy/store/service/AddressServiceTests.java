package com.cy.store.service;

import com.cy.store.entity.Address;
import com.cy.store.entity.User;
import com.cy.store.service.ex.ServiceException;
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
public class AddressServiceTests {
    @Autowired
    private IAddressService addressService;


    @Test
    public void addNewAddress(){
        Address address=new Address();
        address.setPhone("19576464699");
        address.setName("man");
        addressService.addressNewAddress(2,"管理员",address);
    }

    @Test
    public void delete(){
        addressService.delete(7,13,"管理员");
    }

}
