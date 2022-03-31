package com.cy.store.mapper;

/**
 * @author Guomua
 * @Description
 * @date
 **/

import com.cy.store.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/** 用户模块的持久层接口 */
public interface UserMapper {

    /**
     * 根据用户的数据
     * User 用户的数据
     * 受影响的行数(增、删、改，都受影响的行数作为返回值，可以根据返回值来判断是否执行成功)
     */
    Integer insert(User user);

    /**
     * 根据用户名来查询用户的数据
     * @param username 用户名
     * @return  如果找到对应的用户则返回这个用户的数据，如果没找到则返回null
     */
    User findByUsername(String username);

    /**
     * 根据用户的uid来修改用户密码
     * @param uid   用户的id
     * @param password 用户输入的新密码
     * @param modifiedUser 表示修改的执行者
     * @param modifiedTime 表示修改数据的时间
     * @return  返回值为受影响的行数
     */
    Integer updatePasswordByUid(Integer uid,
                                String password,
                                String modifiedUser,
                                Date modifiedTime);

    /**
     *  根据用户的id查询用户的数据
     * @param uid   用户的id
     * @return   如果找到则返回对象，反之返回null值
     */
    User findByUid(Integer uid);


    /**
     *  更新用户的数据信息
     * @param user 用户的数据
     * @return 返回值为受影响的行数
     */
    Integer updateInfoByUid(User user);

    /**
     *  .@Param("SQL映射文件中#{}占位符的变量名"):解决的问题是当SQL语句占位符
     *  和映射的接口方法参数名不一致时，需要将某个参数强行注入到某个占位符变量上时，
     *  可以使用@Param这个注解来标注映射的关系
     *
     *  修改用户的uid值来修改用户的头像
     * @param uid
     * @param avatar
     * @param modifiedUser
     * @param modifiedTime
     * @return
     */
    Integer updateAvatarByUid(
            @Param("uid") Integer uid,
            @Param("avatar") String avatar,
            @Param("modifiedUser") String modifiedUser,
            @Param("modifiedTime") Date modifiedTime);


}
