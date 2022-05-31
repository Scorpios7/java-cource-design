package com.scau.shop.service.ex;

//邮政编码长度大于6的异常
public class CodeLengthLimitedException extends ServiceException{
    public CodeLengthLimitedException() {
    }

    public CodeLengthLimitedException(String message) {
        super(message);
    }

    public CodeLengthLimitedException(String message, Throwable cause) {
        super(message, cause);
    }

    public CodeLengthLimitedException(Throwable cause) {
        super(cause);
    }

    public CodeLengthLimitedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
