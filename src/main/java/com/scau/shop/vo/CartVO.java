package com.scau.shop.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

//购物车数据的Value Object类
//由于涉及多表关联查询，必然没有哪个实体类可以封装此次的查询结果，因此需要创建VO类
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartVO implements Serializable {
    private Integer cid;
    private Integer uid;
    private Integer pid;
    private Long price; //t_product.price
    private Integer num; //t_cart.num
    private String title; //t_product.title
    private Long realPrice;
    private String image; //t_product.image
}
