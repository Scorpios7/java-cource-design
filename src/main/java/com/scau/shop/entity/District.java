package com.scau.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/** 省/市/区数据的实体类 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class District implements Serializable {
    private Integer id;  //主键，自增
    private String parent;  //省市区的父类，省的父类都是"86，即中国
    private String code;   //每一个省市区都有独立的code
    private String name;  //省市区的名字
}
