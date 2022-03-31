package com.cy.store.mapper;

import com.cy.store.entity.Address;
import com.cy.store.entity.District;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
public class DistrictMapperTests {
    //idea有检查的功能，接口是不能够直接创建Bean的(动态代理技术来解决)
    @Autowired
    private DistrictMapper districtMapper;

    @Test
    public void findByParent(){
        List<District> list=districtMapper.findByParent("120100");
        for (District d:list){
            System.out.println(d);
        }

    }
    @Test
    public void findNameByCode(){
        String name=districtMapper.findNameByCode("610000");
        System.out.println(name);
    }
}
