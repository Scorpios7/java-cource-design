package com.scau.shop.service.ex;

//商品已下架异常
public class ProductIsBanedException extends ServiceException{
    public ProductIsBanedException() {
    }

    public ProductIsBanedException(String message) {
        super(message);
    }

    public ProductIsBanedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductIsBanedException(Throwable cause) {
        super(cause);
    }

    public ProductIsBanedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
