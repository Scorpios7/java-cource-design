package com.scau.shop.mapper;

import com.scau.shop.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserMapperTest {

//    @Autowired
//    private UserMapper userMapper;
//
//    @Test
//    public void register() {
//        User user = new User();
//        user.setUsername("01");
//        user.setPassword("123");
//        Integer row = userMapper.register(user);
//        if (row == 1) System.err.println("注册成功");
//        System.out.println(user);
//    }
//
//    @Test
//    public void findByUserName() {
//        String username = "01";
//        System.out.println(userMapper.findByUserName(username));
//    }
//
//    @Test
//    public void changepassword() {
//        Integer uid = 1;
//        User user = userMapper.findByUid(uid);
//        Integer rows = userMapper.changePassword(uid, "1234", new Date());
//        System.err.println("rows=" + rows);
//    }
//
//    @Test
//    public void findByUid() {
//        Integer uid = 1;
//        User user = userMapper.findByUid(uid);
//        System.err.println(user);
//    }
//
//    @Test
//    public void changeInfo() {
//        Integer uid = 16;
//        User user = userMapper.findByUid(uid);
//        user.setPhone("12345678");
//        user.setGender(1);
//        user.setEmail("123@qq.com");
//        user.setModifiedTime(new Date());
//        Integer rows = userMapper.updateInfo(user);
//        if (rows == 1) {
//            System.out.println("更新成功！");
//            System.out.println(user);
//        }
//    }
}