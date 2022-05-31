package com.scau.shop.util;

import lombok.Data;

import java.io.Serializable;

/**
 * 响应结果类(将该类的信息以json的形式发送给前端)
 *
 * @param <E> 响应数据的类型
 */
@Data
public class JsonResult<E> implements Serializable {
    //状态码
    private Integer state;

    //状态描述信息
    private String message;

    //响应的数据
    private E data;

    public JsonResult() {
        super();
    }

    //响应未出现异常且不需要向前端发送数据
    public JsonResult(Integer state) {
        super();
        this.state = state;
    }

    //出现异常时调用
    public JsonResult(Throwable e) {
        super();
        // 获取异常对象中的异常信息
        this.message = e.getMessage();
    }

    //响应未出现异常且需要向前端发送数据
    public JsonResult(Integer state, E data) {
        super();
        this.state = state;
        this.data = data;
    }
}
