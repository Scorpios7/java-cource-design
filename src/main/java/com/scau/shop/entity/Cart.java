package com.scau.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

//购物车数据的实体类
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart extends BaseEntity implements Serializable {
    private Integer cid; //购物车的cid
    private Integer uid;  //用户的uid
    private Integer pid; //商品的pid
    private Integer num;  //购物车某个商品的数量
}
