package com.scau.shop.mapper;

import com.scau.shop.entity.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//处理商品数据的持久层接口
@Mapper
public interface ProductMapper {
    /**
     * 查询热销商品的前四名
     * @return 热销商品前四名的集合
     */
    List<Product> findHotList();

    /**
     * 查询最新商品的前四名
     * @return  最新商品的前四名的集合
     */
    List<Product> findNewList();

    /**
     * 根据商品id查询商品详情
     * @param id 商品id
     * @return
     */
    Product findById(Integer id);

    /**
     *
     * @return
     */
    List<Product> searchProduct(String title);
}
