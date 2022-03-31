package com.cy.store.mapper;

import com.cy.store.entity.Address;
import com.cy.store.entity.Order;
import com.cy.store.entity.OrderItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * @author Guomua
 * @Description
 * @date
 **/

//@SpringBoot:表示标注当前的类是一个测试类，不会随同项目一块打包
@SpringBootTest
//@RunWith:表示启动这个单元测试类（单元测试类是不能够运行的），需要传递一个参数，必须是SpringRunner的实例类型
@RunWith(SpringRunner.class)
public class OrderMapperTests {
    //idea有检查的功能，接口是不能够直接创建Bean的(动态代理技术来解决)
    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void insertOrder() {
        Order order = new Order();
        order.setUid(13);
        order.setRecvName("窝窝头");
        order.setRecvPhone("19522797766");
        orderMapper.insertOrder(order);
    }
    @Test
    public void insertOrderItem() {
        OrderItem orderItem = new OrderItem();
        orderItem.setOid(1);
        orderItem.setPid(10000001);
        orderItem.setTitle("广博(GuangBo)10本装40张A5牛皮纸记事本子日记本办公软抄本GBR0731");
        orderMapper.insertOrderItem(orderItem);
    }
}
