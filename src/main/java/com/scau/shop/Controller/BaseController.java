package com.scau.shop.Controller;

import com.scau.shop.service.ex.*;
import com.scau.shop.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

//控制器类的基类
public class BaseController {
    //操作成功的状态码
    public static final Integer OK = 200;

    //@ExceptionHandler用于统一处理方法抛出的异常
    @ExceptionHandler(ServiceException.class)
    public JsonResult<Void> handlerException(Throwable e) {
        JsonResult<Void> jsonResult = new JsonResult<>(e);
        if (e instanceof PasswordIsNullException) {
            jsonResult.setState(4000);
        } else if (e instanceof UserNameExsistedException) {
            jsonResult.setState(4001);
        } else if (e instanceof UserNameIsNullException) {
            jsonResult.setState(4002);
        } else if (e instanceof PasswordNotEqualsConfirmedException) {
            jsonResult.setState(4003);
        } else if (e instanceof UserNotFoundException) {
            jsonResult.setState(4004);
        } else if (e instanceof PasswordNotMatchException) {
            jsonResult.setState(4005);
        } else if (e instanceof UserIsDeleteException) {
            jsonResult.setState(4006);
        }else if (e instanceof InsertException) {
            jsonResult.setState(5000);
        }else if(e instanceof UpdateException){
            jsonResult.setState(5001);
        }else if(e instanceof DeleteException){
            jsonResult.setState(5002);
        }else if(e instanceof CodeLengthLimitedException){
            jsonResult.setState(6000);
        }else if(e instanceof ProductIsBanedException){
            jsonResult.setState(7000);
        }else if(e instanceof FavoriteExsistedException){
            jsonResult.setState(8000);
        }
        return jsonResult;
    }

    /**
     * 从HttpSession对象中获取uid
     * @param session HttpSession对象啊
     * @return 返回值为当前登录用户的uid
     */
    protected final Integer getUidFromSession(HttpSession session){
        return Integer.valueOf(session.getAttribute("uid").toString());
    }

    /**
     * 从HttpSession对象中获取username
     * @param session
     * @return 返回值为当前登录用户的用户名
     */
    protected final String getUsernameFromSession(HttpSession session){
        return session.getAttribute("username").toString();
    }
}
