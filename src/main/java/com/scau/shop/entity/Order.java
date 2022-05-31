package com.scau.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

//订单实体类
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order extends BaseEntity implements Serializable {
    private Integer oid;  //订单oid
    private Integer uid;  //用户uid
    private String recvName; //收货人姓名
    private String recvPhone; //收货人电话
    private String recvProvince; //收货人所在省
    private String recvCity; //收货人所在市
    private String recvArea; //收货人所在区
    private String recvAddress;  //收货人详细地址
    private Long totalPrice;  //支付商品的总价格
    private Integer status; //订单状态：0-待付款，1-待收货，2-待评价，3-已关闭，4-已完成 ,5-退货退款
    private Date orderTime;  //订单创建时间
    private Date payTime;  //订单支付时间
}
