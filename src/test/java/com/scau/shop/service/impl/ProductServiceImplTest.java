package com.scau.shop.service.impl;

import com.scau.shop.entity.Product;
import com.scau.shop.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceImplTest {
    @Autowired
    private ProductService productService;

//    @Test
//    public void findHotList(){
//        List<Product> list = productService.findHotList();
//        for (Product product : list) {
//            System.err.println(product);
//        }
//    }
//
//    @Test
//    public void findById(){
//        try {
//            Product product = productService.findById(10000001);
//            System.err.println(product);
//        } catch (Exception e) {
//            System.err.println(e.getClass().getSimpleName());
//            System.err.println(e.getMessage());
//        }
//    }
//
//    @Test
//    public void findNewList(){
//        List<Product> list = productService.findNewList();
//        for (Product product : list) {
//            System.err.println(product);
//        }
//    }
}