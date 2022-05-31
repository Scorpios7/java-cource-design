package com.scau.shop.service;

import com.scau.shop.entity.Order;
import com.scau.shop.entity.OrderItem;
import com.scau.shop.entity.Product;

import java.util.List;

public interface OrderService {
    /**
     * 创建订单
     * @param aid 收货地址的id
     * @param cids  即将购买的商品数据在购物车表中的id
     * @param uid 当前登录的用户的id
     * @return 成功创建的订单数据
     */
    Order insertOrder(Integer aid,Integer[] cids,Integer uid);

    /**
     * 创建单个商品的订单
     * @param aid 地址oid
     * @param num 购买的商品数量
     * @param id 商品id
     * @param uid 用户uid
     * @return 订单对象
     */
    Order insertSingleProductOrder(Integer aid, Integer num, Integer id,Integer uid);

    /**
     * 通过uid找到所有的OrderVo对象
     * @param uid 用户uid
     * @return OrderVo集合
     */
    List<Order>findAllOrderByUid(Integer uid);

    /**
     * 找到用户待付款的OrderVo对象
     * @param uid 用户uid
     * @return OrderVo集合
     */
    List<Order>findWaitForPayOrderByUid(Integer uid);


    /**
     * 确认收货
     * @param oid 订单商品id
     * @return 受影响的行数
     */
    void confirmReceipt(Integer id);

    /**
     * 确认支付状态
     * @param oid 订单商品oid
     */
    void confirmPay(Integer oid,String password);

    /**
     * 获取订单商品
     * @param oid 订单oido
     * @return Order集合
     */
    List<OrderItem>findOrderItemByOid(Integer oid);

    /**
     * 找到待收货商品
     * @param uid 用户uid
     * @return OrderItem集合
     */
    List<OrderItem>findNoReceiveOrderItem(Integer uid);

    /**
     * 找到待评论商品
     * @param uid 用户uid
     * @return OrderItem集合
     */
    List<OrderItem>findNoCommentOrderItem(Integer uid);

    /**
     * 找到订单已完成商品
     * @param uid 用户uid
     * @return OrderItem集合
     */
    List<OrderItem>findFinishedOrderItem(Integer uid);

    /**
     * 根据oid获取订单
     * @param oid 订单oid
     * @return Order对象
     */
    Order getOrderByOid(Integer oid);

    /**
     * 将orderItem的status改为4，即已完成
     * @param id orderItem的id
     * @return 受影响的行数
     */
    void setCommentStatus(Integer id);
}
