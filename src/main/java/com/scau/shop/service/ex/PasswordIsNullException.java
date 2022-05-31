package com.scau.shop.service.ex;

//输入的密码为空的异常
public class PasswordIsNullException extends ServiceException{
    public PasswordIsNullException() {
    }

    public PasswordIsNullException(String message) {
        super(message);
    }

    public PasswordIsNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordIsNullException(Throwable cause) {
        super(cause);
    }

    public PasswordIsNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
