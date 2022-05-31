package com.scau.shop.mapper;

import com.scau.shop.entity.Cart;
import com.scau.shop.vo.CartVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CartMapperTest {
    @Autowired
    private CartMapper cartMapper;

//    @Test
//    public void CartMapper() {
//        Cart cart = new Cart();
//        cart.setUid(1);
//        cart.setPid(2);
//        cart.setNum(3);
//        cart.setCreatedTime(new Date());
//        cart.setModifiedTime(new Date());
//        Integer rows = cartMapper.addCart(cart);
//        System.out.println("rows=" + rows);
//    }

    @Test
    public void updateNumByCid() {
        Integer cid = 2;
        Integer num = 7;
        Integer rows = cartMapper.updateNumByCid(cid, num, new Date());
        if(rows==1) System.err.println("更新成功！");
    }

    @Test
    public void findCartByUidAndPid() {
        Integer uid = 1;
        Integer pid = 2;
        Cart cart = cartMapper.findCartByUidAndPid(uid, pid);
        System.err.println(cart);
    }

    @Test
    public void findVOByUid(){
        Integer uid = 1;
        List<CartVO> list = cartMapper.findVOByUid(uid);
        for (CartVO cartVO : list) {
            System.err.println(cartVO);
        }
    }

    @Test
    public void findByCid(){
        Integer cid = 4;
        System.err.println(cartMapper.findByCid(cid));
    }

    @Test
    public void findVOByCids(){
        Integer[] cids = {2,3,4,5};
        List<CartVO> list = cartMapper.findVOByCids(cids);
        for (CartVO cartVO : list) {
            System.err.println(cartVO);
        }
    }

    @Test
    public void deleteByCid(){
        Integer rows = cartMapper.deleteByCid(4);
        System.err.println(rows);
    }

    
}