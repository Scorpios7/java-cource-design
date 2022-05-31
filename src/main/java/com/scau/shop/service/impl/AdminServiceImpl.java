package com.scau.shop.service.impl;

import com.scau.shop.entity.Product;
import com.scau.shop.mapper.AdminMapper;
import com.scau.shop.service.AdminService;
import com.scau.shop.service.ex.InsertException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    //文件路径的根
    private String parent = "\\images\\portal\\";

    @Override
    public void addProduct(Product product, List<MultipartFile> files) {

        if(files == null) throw new InsertException("文件为空!");

        //复制文件夹
        Long time = System.currentTimeMillis();
        String name = time.toString();
        String fileName = parent+name;
        File dest = new File(fileName);
        for (MultipartFile file : files) {
            File newFile = new File(dest,file.getOriginalFilename());
            try {
                file.transferTo(newFile);
            } catch (IOException e) {
                e.printStackTrace();
                throw new InsertException("文件上传失败！");
            }
        }


        product.setCategoryId(163);
        product.setStatus(1);
        product.setPriority(10);
        Date date = new Date();
        product.setCreatedTime(date);
        product.setModifiedTime(date);
        product.setImage(fileName);
        Integer row = adminMapper.addProduct(product);
        if(row != 1) throw new InsertException("添加商品失败！");
    }
}
