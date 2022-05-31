package com.scau.shop.service;

import com.scau.shop.entity.User;

public interface UserService {
    /**
     * 用户注册
     * @param user
     * @param confirmedPassword  确认密码所输入的值
     */
    void register(User user,String confirmedPassword);

    /**
     *
     * @param username
     * @param password
     * @return
     */
    User login(String username,String password);

    /**
     * 修改密码
     * @param uid  用户的uid，从session中获得
     * @param oldPassword  原密码
     * @param newPassword  新密码
     * @param confirmedPassword  确认密码
     */
    void changePassword(Integer uid,String oldPassword,String newPassword,String confirmedPassword);

    /**
     * 1.将用户信息发送到前端，以显示用户的资料
     * 2.只设置user的username,phone，gender和email，以减少前后端交互所产生的流量并提升传输效率
     * @param uid
     * @return  返回值为User对象
     */
    User findByUid(Integer uid);

    /**
     * 根据uid修改用户的信息（uid通过sessi获得，user对象通过前端获得）
     * @param uid
     * @param user user中包括的信息有phone,gender,email
     */
    void changeInfo(Integer uid,User user);
}
