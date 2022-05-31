package com.scau.shop.service.impl;

import com.scau.shop.entity.Product;
import com.scau.shop.mapper.AdminMapper;
import com.scau.shop.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdminServiceImplTest {

    @Autowired
    private AdminService adminService;

//    @Test
//    public void addProduct(){
//        Product product = new Product();
//        product.setCategoryId(163);
//        product.setItemType("iphone13");
//        product.setTitle("2022新款iphone13远峰蓝");
//        product.setSellPoint("新货上市");
//        product.setPrice(7999L);
//        product.setNum(1000);
//        File file = new File("D:\\JavaProjects\\shop\\src\\main\\resources\\static\\images\\" +
//                "portal\\00GuangBo1040A5GBR0731");
//        List<MultipartFile> files = new ArrayList<>();
//        File[] listFiles = file.listFiles();
//        for (File listFile : listFiles) {
//            files.add(listFile);
//        }
//        adminService.addProduct(product,files);
//    }
}