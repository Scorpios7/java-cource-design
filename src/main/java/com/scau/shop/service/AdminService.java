package com.scau.shop.service;

import com.scau.shop.entity.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AdminService {
    /**
     * 添加商品
     * @param product 商品对象
     * @param file 商品图片文件
     */
    void addProduct(Product product, List<MultipartFile> files);
}
