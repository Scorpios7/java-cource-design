package com.scau.shop.service.impl;

import com.scau.shop.entity.User;
import com.scau.shop.mapper.UserMapper;
import com.scau.shop.service.UserService;
import com.scau.shop.service.ex.*;
import com.scau.shop.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(User user, String confirmedPassword) {
        String username = user.getUsername();
        String password = user.getPassword();
        //在数据库查询该用户是否已存在
        User result = userMapper.findByUserName(username);
        if (username == null || username.equals("")) throw new UserNameIsNullException("用户名不能为空！");
        if (password == null || password.equals("")) throw new PasswordIsNullException("密码不能为空！");
        if (result != null) throw new UserNameExsistedException("该用户名已存在！");
        if (!password.equals(confirmedPassword)) throw new PasswordNotEqualsConfirmedException("两次输入的密码不一致！");
        //创建时间对象
        Date date = new Date();
        //随机获取盐值，用来加密
        String salt = UUID.randomUUID().toString().toUpperCase();
        //获取加密后的密码
        String md5Password = Utils.getMd5Password(password, salt);
        //补全数据
        user.setPassword(md5Password);
        user.setIsDelete(0);
        user.setSalt(salt);
        user.setCreatedTime(date);
        user.setModifiedTime(date);
        //调用持久层register方法，执行注册并获取返回值(受影响的行数)
        Integer row = userMapper.register(user);
        if (row != 1) {
            throw new InsertException("添加用户数据出现未知错误，请联系系统管理员");
        }
    }

    @Override
    public User login(String username, String password) {
        User result = userMapper.findByUserName(username);
        if (username == null || username.equals("")) throw new UserNameIsNullException("用户名不能为空！");
        if (password == null || password.equals("")) throw new PasswordIsNullException("密码不能为空！");
        if (result == null) throw new UserNotFoundException("该用户不存在！");
        //判断密码是否正确
        String salt = result.getSalt();
        String md5Password = Utils.getMd5Password(password, salt);
        if (!md5Password.equals(result.getPassword())) {
            throw new PasswordNotMatchException("密码错误");
        }
        //判断用户是否被管理员封号
        if (result.getIsDelete() == 1) {
            throw new UserIsDeleteException("您的账号暂时被停封，请联系系统管理员");
        }
        User user = new User();
        user.setUid(result.getUid());
        user.setUsername(result.getUsername());
        user.setAvatar(result.getAvatar());
        return user;
    }

    @Override
    public void changePassword(Integer uid, String oldPassword, String newPassword, String confirmedPassword) {
        User user = userMapper.findByUid(uid);
        if (user.getIsDelete() == 1) throw new UserIsDeleteException("您的账号暂时被停封，请联系系统管理员");
        //判断输入的原密码是否正确
        String salt = user.getSalt();
        oldPassword = Utils.getMd5Password(oldPassword, salt);
        newPassword = Utils.getMd5Password(newPassword, salt);
        if (!oldPassword.equals(user.getPassword())) throw new PasswordNotMatchException("原密码错误！");
        if (oldPassword.equals(newPassword)) throw new PasswordNotMatchException("不能与原密码相同！");
        confirmedPassword = Utils.getMd5Password(confirmedPassword, salt);
        if (!confirmedPassword.equals(newPassword)) {
            throw new PasswordNotEqualsConfirmedException("两次输入的密码不一致！");
        }
        //执行更新密码
        Integer rows = userMapper.changePassword(uid, newPassword, new Date());
        if (rows != 1) throw new UpdateException("更新用户数据时出现未知错误，请联系系统管理员");
    }

    @Override
    public User findByUid(Integer uid) {
        User result = userMapper.findByUid(uid);
        if (result.getIsDelete() == 1) throw new UserIsDeleteException("您的账号暂时被停封，请联系系统管理员");
        //创建新的User对象
        User user = new User();
        user.setUsername(result.getUsername());
        user.setEmail(result.getEmail());
        user.setGender(result.getGender());
        user.setPhone(result.getPhone());
        return user;
    }

    @Override
    public void changeInfo(Integer uid, User user) {
        User result = userMapper.findByUid(uid);
        if (result.getIsDelete() == 1) throw new UserIsDeleteException("您的账号暂时被停封，请联系系统管理员");
        //因为只用改phone,gender,email,modifiedTime四个值，所以传user就行了，提升效率
        user.setUid(uid);
        user.setModifiedTime(new Date());
        Integer rows = userMapper.updateInfo(user);
        if (rows != 1) throw new UpdateException("更新用户数据时出现未知错误，请联系系统管理员");
    }
}
