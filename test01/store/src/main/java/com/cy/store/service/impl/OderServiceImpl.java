package com.cy.store.service.impl;

import com.cy.store.entity.Address;
import com.cy.store.entity.Order;
import com.cy.store.entity.OrderItem;
import com.cy.store.mapper.OrderMapper;
import com.cy.store.service.IAddressService;
import com.cy.store.service.ICartService;
import com.cy.store.service.IOrderService;
import com.cy.store.service.ex.InsertException;
import com.cy.store.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Guomua
 * @Description
 * @date
 **/
@Service
public class OderServiceImpl implements IOrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private IAddressService addressService;
    @Autowired
    private ICartService cartService;



    @Override
    public Order create(Integer aid, Integer uid, String username, Integer[] cids) {
       //即将要下单的列表
        List<CartVO>list=cartService.getVOByCid(uid, cids);
       //计算产品的总价
        Long totalPrice=0L;
        //创建订单详细项的数据
        for (CartVO c:list){
            totalPrice+=c.getRealPrice()*c.getNum();

        }
        Address address=addressService.getByAid(aid,uid);
        Order order=new Order();
        order.setUid(uid);
        //收货地址数据
        order.setRecvName(address.getName());
        order.setRecvPhone(address.getPhone());
        order.setRecvProvince(address.getProvinceName());
        order.setRecvCity(address.getCityCode());
        order.setRecvArea(address.getAreaName());
        order.setRecvAddress(address.getAddress());
        //支付、总价、时间
        order.setStatus(0);
        order.setTotalPrice(totalPrice);
        order.setOrderTime(new Date());
        //日志
        order.setCreatedUser(username);
        order.setCreatedTime(new Date());
        order.setModifiedUser(username);
        order.setModifiedTime(new Date());

        //查询数据
        Integer rows=orderMapper.insertOrder(order);
        if (rows!=1){
            throw new InsertException("插入数据异常");
        }

        //创建订单详细项的数据
        for (CartVO c:list){
            //创建一个订单项数据对象
            OrderItem orderItem=new OrderItem();
            orderItem.setOid(order.getOid());
            orderItem.setPid(c.getPid());
            orderItem.setTitle(c.getTitle());
            orderItem.setImage(c.getImage());
            orderItem.setPrice(c.getRealPrice());
            orderItem.setNum(c.getNum());
            //日志字段
            orderItem.setCreatedUser(username);
            orderItem.setCreatedTime(new Date());
            orderItem.setModifiedUser(username);
            orderItem.setModifiedTime(new Date());
            //插入数据操作
            rows=orderMapper.insertOrderItem(orderItem);
            if (rows!=1){
                throw new InsertException("插入数据异常");
            }
        }


        return order;
    }
}
