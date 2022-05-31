package com.scau.shop.service.ex;

//用户被管理员封号的异常
public class UserIsDeleteException extends ServiceException{
    public UserIsDeleteException() {
    }

    public UserIsDeleteException(String message) {
        super(message);
    }

    public UserIsDeleteException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserIsDeleteException(Throwable cause) {
        super(cause);
    }

    public UserIsDeleteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
