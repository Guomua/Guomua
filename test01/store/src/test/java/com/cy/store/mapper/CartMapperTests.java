package com.cy.store.mapper;

import com.cy.store.entity.Address;
import com.cy.store.entity.Cart;
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
public class CartMapperTests {
    //idea有检查的功能，接口是不能够直接创建Bean的(动态代理技术来解决)
    @Autowired
    private CartMapper cartMapper;

    @Test
    public void insert(){
        Cart cart = new Cart();
        cart.setUid(13);
        cart.setPid(10000021);
        cart.setNum(2);
        cart.setPrice(1000L);
        cartMapper.insert(cart);
    }

    @Test
    public void updateNumByCid(){
        cartMapper.updateNumByCid(1,4,"张三",new Date());
    }

    @Test
    public void findByUidAndPid(){
        Cart cart=cartMapper.findByUidAndPid(13,10000021);
        System.err.println(cart);
    }

    @Test
    public void findVOByUid(){
        System.out.println(cartMapper.findVOByUid(13));
    }

    @Test
    public void findByCid(){
        System.out.println(cartMapper.findByCid(1));
    }

    @Test
    public void findVOByCid(){
        Integer []cids={1,2,5,30,80,40};
        System.out.println(cartMapper.findVOByCid(cids));
    }

}
