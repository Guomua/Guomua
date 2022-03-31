package com.cy.store.service;

/**
 * @author Guomua
 * @Description
 * @date
 **/

import com.cy.store.entity.Address;

import java.util.List;

/** 收货地址业务层接口 */
public interface IAddressService {
    void addressNewAddress(Integer uid, String username, Address address);

    List<Address> getByUid(Integer uid);

    /**
     * 修改某个用户某条收货地址数据为默认收货地址
     * @param aid 收货地址的id
     * @param uid 用户的id
     * @param username 表示修改执行的人
     */
    void setDefault(Integer aid,Integer uid,String username);

    /**
     * 删除用户选中的收货地址数据
     * @param aid 收货地址id
     * @param uid 用户id
     * @param username 用户名
     */
    void delete(Integer aid,Integer uid,String username);

    Address getByAid(Integer aid,Integer uid);

}
