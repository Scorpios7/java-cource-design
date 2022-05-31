package com.scau.shop.mapper;

import com.scau.shop.entity.Cart;
import com.scau.shop.vo.CartVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface CartMapper {
    /**
     * 增加购物车数据
     *
     * @param cart 购物车对象
     * @return 受影响的行数
     */
    Integer addCart(Cart cart);

    /**
     * 修改购物车数据中商品的数量（前端可以增加和减少）
     *
     * @param cid          购物车数据的id
     * @param num          新的数量
     * @param modifiedTime 修改时间
     * @return 受影响的行数
     */
    Integer updateNumByCid(
            @Param("cid") Integer cid,
            @Param("num") Integer num,
            @Param("modifiedTime") Date modifiedTime);

    /**
     * 根据用户id和商品id查询购物车中的数据,因为前端只能传uid和pid，所以要根据uid和pid找到cart
     *
     * @param uid 用户id
     * @param pid 商品id
     * @return 匹配的购物车数据，如果该用户的购物车中并没有该商品，则返回null
     */
    Cart findCartByUidAndPid(
            @Param("uid") Integer uid,
            @Param("pid") Integer pid);

    /**
     * 查询某用户的购物车数据
     * @param uid 用户id
     * @return 该用户的购物车数据的列表
     */
    List<CartVO> findVOByUid(Integer uid);

    /**
     * 通过cid找到购物车数据
     * @param cid
     * @return
     */
    Cart findByCid(Integer cid);

    /**
     * 根据若干个购物车数据id查询详情的列表
     * @param cids 若干个购物车数据id
     * @return 匹配的购物车数据详情的列表
     */
    List<CartVO>findVOByCids(Integer[] cids);

    /**
     * 删除购物车
     * @param cid  购物车cid
     * @return  受影响的行数
     */
    Integer deleteByCid(Integer cid);
}
