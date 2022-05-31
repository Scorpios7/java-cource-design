package com.scau.shop.vo;

import com.scau.shop.entity.Order;
import com.scau.shop.entity.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

//订单商品的Value Object类
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderVO {
    Order order;  //订单类
    List<OrderItem> list; //一个订单有多个商品
}
