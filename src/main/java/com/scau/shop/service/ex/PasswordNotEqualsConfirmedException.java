package com.scau.shop.service.ex;

//两次输入密码不一致的异常
public class PasswordNotEqualsConfirmedException extends ServiceException{
    public PasswordNotEqualsConfirmedException() {
        super();
    }

    public PasswordNotEqualsConfirmedException(String message) {
        super(message);
    }

    public PasswordNotEqualsConfirmedException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordNotEqualsConfirmedException(Throwable cause) {
        super(cause);
    }

    public PasswordNotEqualsConfirmedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
