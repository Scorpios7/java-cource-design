package com.scau.shop.service.impl;

import com.scau.shop.service.CartService;
import com.scau.shop.vo.CartVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CartServiceImplTest {
    @Autowired
    private CartService cartService;

//    @Test
//    public void addCart(){
//        Integer uid = 1;
//        Integer pid = 3;
//        Integer num = 9;
//        cartService.addCart(uid,pid,num);
//    }
//
//    @Test
//    public void findVOByUid(){
//        List<CartVO> list = cartService.findVOByUid(16);
//        for (CartVO cartVO : list) {
//            System.err.println("price="+cartVO.getRealPrice());
//        }
//    }
//
//    @Test
//    public void addNum(){
//        Integer cid = 4;
//        Integer num = cartService.addNum(cid);
//        System.err.println("num="+num);
//    }
//
//    @Test
//    public void reduceNum(){
//        Integer cid = 4;
//        Integer num = cartService.reduceNum(cid);
//        System.err.println("num="+num);
//    }
//
//    @Test
//    public void findVOByCids(){
//        Integer[] cids = {2,3,4,5};
//        List<CartVO> list = cartService.findVOByCids(cids);
//        for (CartVO cartVO : list) {
//            System.err.println(cartVO);
//        }
//    }
//
//    @Test
//    public void deleteByCid(){
//        cartService.deleteByCid(7);
//    }
}