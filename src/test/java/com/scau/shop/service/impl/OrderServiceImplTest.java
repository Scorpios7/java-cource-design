package com.scau.shop.service.impl;

import com.scau.shop.entity.Order;
import com.scau.shop.entity.OrderItem;
import com.scau.shop.service.OrderService;
import com.scau.shop.vo.OrderVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class OrderServiceImplTest {
    @Autowired
    private OrderService orderService;

//    @Test
//    public void insertOrder(){
//        Integer aid = 7;
//        Integer[] cids = {4,5};
//        Integer uid = 16;
//        orderService.insertOrder(aid,cids,uid);
//    }
//
//    @Test
//    public void findAllOrderByUid(){
//        List<Order> orders = orderService.findAllOrderByUid(16);
//        for (Order order : orders) {
//            System.err.println(order);
//        }
//    }
//
//    @Test
//    public void findWaitForPayOrderByUid(){
//        List<Order> orders = orderService.findWaitForPayOrderByUid(16);
//        for (Order order : orders) {
//            System.err.println(order);
//        }
//    }
//
//    @Test
//    public void ConfirmReceipt(){
//        orderService.confirmReceipt(3);
//    }
//
//    @Test
//    public void findOrderItemByOid(){
//        List<OrderItem> items = orderService.findOrderItemByOid(3);
//        for (OrderItem item : items) {
//            System.err.println(item);
//        }
//    }
//
//    @Test
//    public void setCommentStatus(){
//        orderService.setCommentStatus(4);
//    }
//
//    @Test
//    public void findFinishedOrderItem(){
//        List<OrderItem> items = orderService.findFinishedOrderItem(16);
//        for (OrderItem item : items) {
//            System.err.println(item);
//        }
//    }
//
//    @Test
//    public void test() {
//        System.err.println(orderService);
//    }
}