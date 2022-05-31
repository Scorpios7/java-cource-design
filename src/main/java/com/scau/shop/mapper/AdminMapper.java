package com.scau.shop.mapper;

import com.scau.shop.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminMapper {

    /**
     * 管理员添加商品
     * @param product 商品对象
     * @return 受影响的行数
     */
    Integer addProduct(Product product);
}
