package com.scau.shop.service.ex;

//用户名已存在的异常
public class UserNameExsistedException extends ServiceException{
    public UserNameExsistedException() {
    }

    public UserNameExsistedException(String message) {
        super(message);
    }

    public UserNameExsistedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNameExsistedException(Throwable cause) {
        super(cause);
    }

    public UserNameExsistedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
