package com.scau.shop.mapper;

import com.scau.shop.entity.Order;
import com.scau.shop.entity.OrderItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderMapperTest {
    @Autowired
    private OrderMapper orderMapper;

//    @Test
//    public void insertOrder() {
//        Order order = new Order();
//        order.setUid(16);
//        order.setRecvName("小林");
//        Integer rows = orderMapper.insertOrder(order);
//        System.out.println("rows=" + rows);
//        System.err.println("oid = "+order.getOid());
//    }
//
//    @Test
//    public void insertOrderItem() {
//        OrderItem orderItem = new OrderItem();
//        orderItem.setUid(16);
//        orderItem.setStatus(0);
//        orderItem.setOid(15);
//        orderItem.setPid(2);
//        orderItem.setTitle("高档铅笔");
//        Integer rows = orderMapper.insertOrderItem(orderItem);
//        System.out.println("rows=" + rows);
//    }
//
//    @Test
//    public void findAllOrderByUid(){
//        List<Order> list = orderMapper.findAllOrderByUid(16);
//        for (Order order : list) {
//            System.err.println(order);
//        }
//    }
//
//    @Test
//    public void findOrderItemByOid(){
//        List<OrderItem> list = orderMapper.findOrderItemByOid(4);
//        for (OrderItem item : list) {
//            System.err.println(item);
//        }
//    }
//
//    @Test
//    public void ConfirmReceipt(){
//        Integer rows = orderMapper.confirmReceipt(3,new Date());
//        System.err.println("rows = "+rows);
//    }
//
//    @Test
//    public void findNoReceiveOrderItem(){
//        List<OrderItem> list = orderMapper.findNoReceiveOrderItem(16);
//        for (OrderItem item : list) {
//            System.err.println(item);
//        }
//    }
//
//    @Test
//    public void getOrderByOid(){
//        Order order = orderMapper.getOrderByOid(3);
//        System.err.println(order);
//    }
//
//    @Test
//    public void setCommentStatus(){
//        orderMapper.setCommentStatus(4);
//    }
//
//    @Test
//    public void findFinishedOrderItem(){
//        List<OrderItem> items = orderMapper.findFinishedOrderItem(16);
//        for (OrderItem item : items) {
//            System.err.println(item);
//        }
//    }
}