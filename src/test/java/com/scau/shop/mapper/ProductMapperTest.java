package com.scau.shop.mapper;

import com.scau.shop.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductMapperTest {
    @Autowired
    private ProductMapper productMapper;

//    @Test
//    public void findHotList(){
//        List<Product> list = productMapper.findHotList();
//        for (Product product : list) {
//            System.err.println(product);
//        }
//    }
//
//    @Test
//    public void findById(){
//        Product product = productMapper.findById(10000017);
//        System.err.println(product);
//    }
//
//    @Test
//    public void findNewList(){
//        List<Product> list = productMapper.findNewList();
//        for (Product product : list) {
//            System.err.println(product);
//        }
//    }
}