package com.cy.store.mapper;

import com.cy.store.entity.Address;
import com.cy.store.entity.User;
import org.apache.ibatis.annotations.Param;
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
public class AddressMapperTests {
    //idea有检查的功能，接口是不能够直接创建Bean的(动态代理技术来解决)
    @Autowired
    private AddressMapper addressMapper;

    @Test
    public void insert(){
        Address address=new Address();
        address.setUid(13);
        address.setPhone("19576464658");
        address.setName("woman");
        addressMapper.insert(address);

    }
    @Test
    public void countByUid(){
        Integer count= addressMapper.countByUid(13);
        System.out.println(count);
    }

    @Test
    public void findByUid(){
        List<Address>list= addressMapper.findByUid(13);
        System.out.println(list);
    }

    @Test
    public void  findByAid(){

        System.err.println(addressMapper.findByAid(6));
    }
    @Test
    public void updateNonDefault(){
        addressMapper.updateNonDefault(13);
    }
    @Test
    public void updateDefaultByAid(){
        addressMapper.updateDefaultByAid(6,"明明",new Date());
    }

    @Test
    public void deleteByAid(){
        addressMapper.deleteByAid(4);
    }

    @Test
    public void findLastModified(){
        System.out.println(addressMapper.findLastModified(13));
    }

}
