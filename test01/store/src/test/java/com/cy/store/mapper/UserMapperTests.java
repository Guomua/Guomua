package com.cy.store.mapper;

import com.cy.store.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author Guomua
 * @Description
 * @date
 **/

//@SpringBoot:表示标注当前的类是一个测试类，不会随同项目一块打包
@SpringBootTest
//@RunWith:表示启动这个单元测试类（单元测试类是不能够运行的），需要传递一个参数，必须是SpringRunner的实例类型
@RunWith(SpringRunner.class)
public class UserMapperTests {
    //idea有检查的功能，接口是不能够直接创建Bean的(动态代理技术来解决)
    @Autowired
    private UserMapper userMapper;
    /**
     * 单元测试方法：就可以单独独立运行，不用启动整个项目，可以做单元测试，提升了代码的测试效率
     * 1.必须被@Test注解修饰
     * 2.返回值类型必须是void
     * 3.方法的参数列表不能指定任何类型
     * 4.方法的访问修饰符必须是public
     */
    @Test
    public void insert(){
        User user=new User();
        user.setUsername("test003");
        user.setPassword("123");
        Integer rows=userMapper.insert(user);
        System.out.println(rows);
    }

    @Test
    public void findByUsername(){
        User user= userMapper.findByUsername("tim");
        System.out.println(user);
    }

    @Test
    public void updatePasswordByUid(){
        userMapper.updatePasswordByUid(10,"321","管理员",new Date());
    }


    @Test
    public void  findByUid(){
        System.out.println(userMapper.findByUid(10));
    }


    @Test
    public void updateInfoByUid(){
        User user=new User();
        user.setUid(12);
        user.setPhone("19522797788");
        user.setEmail("test005@qq.com");
        user.setGender(1);
        userMapper.updateInfoByUid(user);
    }

    @Test
    public void updateAvatarByUid(){
        userMapper.updateAvatarByUid(13,
                "/upload/avatar.png",
                "管理员",
                 new Date());
    }
}
