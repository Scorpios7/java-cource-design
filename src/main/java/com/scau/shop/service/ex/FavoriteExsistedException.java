package com.scau.shop.service.ex;

//商品已在收藏夹异常
public class FavoriteExsistedException extends ServiceException{
    public FavoriteExsistedException() {
    }

    public FavoriteExsistedException(String message) {
        super(message);
    }

    public FavoriteExsistedException(String message, Throwable cause) {
        super(message, cause);
    }

    public FavoriteExsistedException(Throwable cause) {
        super(cause);
    }

    public FavoriteExsistedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
