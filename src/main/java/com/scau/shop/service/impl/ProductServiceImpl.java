package com.scau.shop.service.impl;

import com.scau.shop.entity.Product;
import com.scau.shop.mapper.ProductMapper;
import com.scau.shop.service.ProductService;
import com.scau.shop.service.ex.ProductIsBanedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> findHotList() {
        List<Product> list = productMapper.findHotList();
        //将没用的字段设为null，提升传输效率，减少流量
        for (Product product : list) {
            product.setCreatedTime(null);
            product.setModifiedTime(null);
            product.setPriority(null);
        }
        return list;
    }

    @Override
    public Product findById(Integer id) {
        Product product = productMapper.findById(id);
        if(product.getStatus()==2){
            throw new ProductIsBanedException("该商品已下架");
        }
        if(product.getStatus()==3){
            throw new ProductIsBanedException("该商品不存在！");
        }
        //将没用的字段设为null,提升传输效率
        product.setPriority(null);
        product.setModifiedTime(null);
        product.setCreatedTime(null);
        return product;
    }

    @Override
    public List<Product> findNewList() {
        List<Product> list = productMapper.findNewList();
        //将没用的字段设为null，提升传输效率，减少流量
        for (Product product : list) {
            product.setCreatedTime(null);
            product.setModifiedTime(null);
            //product.setPriority(null);
        }
        return list;
    }

    @Override
    public List<Product> searchProduct(String title){
        List<Product> list = productMapper.searchProduct(title);
        return list;
    }
}

