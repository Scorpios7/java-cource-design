package com.scau.shop.Controller;

import com.scau.shop.entity.User;
import com.scau.shop.service.UserService;
import com.scau.shop.util.JsonResult;
import com.scau.shop.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

//处理用户相关请求的控制器
@RestController
@RequestMapping("/users")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @RequestMapping("/reg")
    public JsonResult<Void> register(User user, String confirmedPassword) {
        //调用业务对象执行注册,如果出现异常将被统一拦截处理
        userService.register(user, confirmedPassword);
        //成功后返回json给前端
        return new JsonResult<Void>(OK);
    }

    @RequestMapping("/login")
    public JsonResult<User> login(String username, String password, HttpSession session) {
        // 调用业务对象的方法执行登录，并获取返回值
        User data = userService.login(username, password);

        //登录成功后，将uid和username存入到HttpSession中
        session.setAttribute("uid", data.getUid());
        session.setAttribute("username", data.getUsername());

        // 将以上返回值和状态码OK封装到响应结果中并返回
        return new JsonResult<User>(OK, data);
    }

    @RequestMapping("/change_password")
    public JsonResult<Void> changePassword(String oldPassword, String newPassword,
                                           HttpSession session, String confirmedPassword) {
        //在session中获取用户的uid
        Integer uid = getUidFromSession(session);
        //调用业务层的changePassword方法
        userService.changePassword(uid, oldPassword, newPassword, confirmedPassword);
        return new JsonResult<Void>(OK);
    }

    @RequestMapping("/get_by_uid")
    public JsonResult<User> findByUid(HttpSession session) {
        //从session中获取uid
        Integer uid = getUidFromSession(session);
        //调用业务层的findByUid方法获取user对象
        User data = userService.findByUid(uid);
        return new JsonResult<User>(OK, data);
    }

    @RequestMapping("/change_info")
    public JsonResult<Void>changeInfo(HttpSession session,User user){
        //从session中获取uid
        Integer uid = getUidFromSession(session);
        //调用业务层的changeInfo方法
        userService.changeInfo(uid,user);
        //响应成功
        return new JsonResult<Void>(OK);
    }
}
