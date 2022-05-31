package com.scau.shop.service;

import com.scau.shop.vo.CartVO;

import java.util.List;

public interface CartService {
    /**
     * 将商品添加到购物车,或者更新购物车的数据（num）
     * @param uid  用户的uid
     * @param pid 商品的pid
     * @param amount 增加的数量
     */
    void addCart(Integer uid,Integer pid,Integer amount);

    /**
     * 查询某用户的购物车数据
     * @param uid 用户id
     * @return 该用户的购物车数据的列表
     */
    List<CartVO>findVOByUid(Integer uid);

    /**
     * 在购物车中增加商品数量
     * @param cid 购物车cid，通过前端传到后端
     * @return  返回商品的购买数量
     */
    Integer addNum(Integer cid);

    /**
     * 在购物车中减少商品数量
     * @param cid 购物车cid，通过前端传到后端
     * @return  返回商品的购买数量
     */
    Integer reduceNum(Integer cid);

    /**
     * 根据若干个购物车数据id查询详情的列表
     * @param cids 若干个购物车数据id
     * @return  匹配的购物车数据详情的列表
     */
    List<CartVO>findVOByCids(Integer[] cids);

    /**
     * 删除购物车
     * @param cid 购物车cid
     * @return
     */
    void deleteByCid(Integer cid);
}
