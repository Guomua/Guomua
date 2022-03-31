package com.cy.store.service;

import com.cy.store.entity.User;
import com.cy.store.mapper.UserMapper;
import com.cy.store.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.rowset.serial.SerialException;

/**
 * @author Guomua
 * @Description
 * @date
 **/

//@SpringBootTest:表示标注当前的类是一个测试类，不会随同项目一块打包
@SpringBootTest
//@RunWith:表示启动这个单元测试类（单元测试类是不能够运行的），需要传递一个参数，必须是SpringRunner的实例类型
@RunWith(SpringRunner.class)
public class UserServiceTests {
    //idea有检查的功能，接口是不能够直接创建Bean的(动态代理技术来解决)
    @Autowired
    private IUserService userService;
    /**
     * 单元测试方法：就可以单独独立运行，不用启动整个项目，可以做单元测试，提升了代码的测试效率
     * 1.必须被@Test注解修饰
     * 2.返回值类型必须是void
     * 3.方法的参数列表不能指定任何类型
     * 4.方法的访问修饰符必须是public
     */
    @Test
    public void reg(){
        try {
            User user=new User();
            user.setUsername("test005");
            user.setPassword("321");
            userService.reg(user);
            System.out.println("OK");
        } catch (ServiceException e) {
            //获取类的对象，再获取类的名称
            System.out.println(e.getClass().getSimpleName());
            //获取异常的具体描述信息
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void login(){
        User user= userService.login("guomua110","123");
        System.out.println(user);
    }

    @Test
    public void changePassword(){
        userService.changePassword(12,"管理员","321","123");
    }


    @Test
    public void getByUid(){
        System.err.println(userService.getByUid(12));
    }

    @Test
    public void changeInfo(){
        User user = new User();
        user.setPhone("19131127783");
        user.setEmail("test005@163.com");
        user.setGender(0);
        userService.changeInfo(12,"guomua123",user);
    }

    @Test
    public void changeAvatar(){
        userService.changeAvatar(13,"/upload/test/png","小明");

    }


}
