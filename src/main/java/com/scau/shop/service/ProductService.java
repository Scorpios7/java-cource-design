package com.scau.shop.service;

import com.scau.shop.entity.Product;

import java.util.List;


public interface ProductService {
    /**
     * 查询热销商品的前四名
     * @return 热销商品前四名的集合
     */
    List<Product> findHotList();

    /**
     * 根据id查询商品详情
     * @param id  商品id
     * @return
     */
    Product findById(Integer id);

    /**
     * 查询最新商品的前四名
     * @return 最新商品前四名的集合
     */
    List<Product> findNewList();


    /**
     * 根据用户输入的字段查询对应商品
     * @param title
     * @return
     */
    List<Product> searchProduct(String title);
}
