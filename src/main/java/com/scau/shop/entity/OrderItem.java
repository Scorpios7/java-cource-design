package com.scau.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

//订单中的商品数据
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem extends BaseEntity implements Serializable {
    private Integer id; //主键
    private Integer oid; //该商品所对应的订单
    private Integer pid;  //该商品所对应的pid
    private String title;  //商品标题
    private String image; //商品图片
    private Long price; //商品价格
    private Integer num;  //商品数量
    private Integer status; // //订单中的商品状态：0-待付款，1-待收货，2-待评价，3-已关闭，4-已完成 ,5-退货退款
    private Integer uid;
}
