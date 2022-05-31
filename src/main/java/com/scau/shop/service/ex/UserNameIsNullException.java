package com.scau.shop.service.ex;

//输入的用户名为空的异常
public class UserNameIsNullException extends ServiceException {
    public UserNameIsNullException() {
    }

    public UserNameIsNullException(String message) {
        super(message);
    }

    public UserNameIsNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNameIsNullException(Throwable cause) {
        super(cause);
    }

    public UserNameIsNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
