package com.scau.shop.mapper;

import com.scau.shop.entity.Address;
import com.scau.shop.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

//处理用户数据的持久层接口
@Mapper
public interface UserMapper {
    /**
     * 插入用户数据
     *
     * @param user
     * @return 返回值为受影响的行数
     */
    Integer register(User user);

    /**
     * 查询该用户是否已注册
     *
     * @param username
     * @return
     */
    User findByUserName(String username);

    /**
     * 根据uid更新用户的密码
     * @param uid 用户的uid
     * @param password 用户密码
     * @param modifiedTime 修改时间
     * @return  返回值为受影响的行数
     */
    Integer changePassword(@Param("uid") Integer uid,
                           @Param("password") String password,
                           @Param("modifiedTime") Date modifiedTime);

    /**
     * 根据uid查询用户数据
     * @param uid
     * @return
     */
    User findByUid(Integer uid);

    /**
     * 根据uid更新用户资料
     * @param user  封装了用户id和资料的对象
     * @return 返回值为受影响的行数
     */
    Integer updateInfo(User user);
}
