package com.scau.shop.service.impl;

import com.scau.shop.entity.User;
import com.scau.shop.service.UserService;
import com.scau.shop.service.ex.ServiceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {
    @Autowired
    private UserService userService;

//    @Test
//    public void register() {
//        User user = new User();
//        user.setUsername("02");
//        user.setPassword("123");
//        String confirmedPassword = "123";
//        userService.register(user, confirmedPassword);
//    }
//
//    @Test
//    public void login() {
//        try {
//            User user = new User();
//            user.setUsername("lll");
//            user.setPassword("123");
//            userService.login(user.getUsername(), user.getPassword());
//            System.err.println(user);
//        } catch (Exception e) {
//            System.err.println(e.getClass().getSimpleName());
//            System.err.println(e.getMessage());
//        }
//    }
//
//    @Test
//    public void changePassword() {
//        try {
//            Integer uid = 15;
//            String oldPassword = "123";
//            String newPassword = "1234";
//            String confirmedPassword="123";
//            userService.changePassword(uid, oldPassword, newPassword,confirmedPassword);
//            System.err.println("修改密码成功");
//        } catch (Exception e) {
//            System.err.println(e.getClass().getSimpleName());
//            System.err.println(e.getMessage());
//        }
//    }
//
//    @Test
//    public void findByUid(){
//        try {
//            Integer uid = 16;
//            User user = userService.findByUid(uid);
//            System.err.println(user);
//        } catch (Exception e) {
//            System.err.println(e.getClass().getSimpleName());
//            System.err.println(e.getMessage());
//        }
//    }
//
//    @Test
//    public void changeInfo(){
//        try {
//            Integer uid = 16;
//            User user = new User();
//            user.setPhone("12345");
//            user.setEmail("1111@qq.com");
//            user.setGender(0);
//            userService.changeInfo(uid,user);
//            System.err.println("修改成功！");
//            System.err.println(user);
//        } catch (Exception e) {
//            System.err.println(e.getClass().getSimpleName());
//            System.err.println(e.getMessage());
//        }
//    }
}