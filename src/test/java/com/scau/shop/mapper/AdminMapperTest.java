package com.scau.shop.mapper;

import com.scau.shop.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdminMapperTest {
    @Autowired
    private AdminMapper adminMapper;

//    @Test
//    public void addProduct(){
//        Product product = new Product();
//        product.setCategoryId(163);
//        product.setItemType("iphone13");
//        product.setTitle("2022新款iphone13远峰蓝");
//        product.setSellPoint("新货上市");
//        product.setPriority(10);
//        product.setPrice(7999L);
//        product.setNum(1000);
//        product.setImage("abcd");
//        product.setStatus(1);
//        product.setPriority(10);
//        Date date = new Date();
//        product.setCreatedTime(date);
//        product.setModifiedTime(date);
//        Integer row = adminMapper.addProduct(product);
//        System.err.println("rows = "+row);
//    }
}