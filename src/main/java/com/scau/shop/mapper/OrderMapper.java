package com.scau.shop.mapper;

import com.scau.shop.entity.Order;
import com.scau.shop.entity.OrderItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Mapper
public interface OrderMapper {
    /**
     * 插入订单数据
     * @param order 订单数据
     * @return 受影响的行数
     */
    Integer insertOrder(Order order);

    /**
     * 插入订单商品数据
     * @param orderItem 订单商品数据
     * @return 受影响的行数
     */
    Integer insertOrderItem(OrderItem orderItem);

    /**
     * 通过uid找到所有的订单
     * @param uid 用户uid
     * @return 订单集合
     */
    List<Order> findAllOrderByUid(Integer uid);

    /**
     * 通过oid找到某个订单的所有商品
     * @param oid 订单oid
     * @return OrderItem集合
     */
    List<OrderItem> findOrderItemByOid(Integer oid);

    /**
     * 确认收货
     * @param id 订单商品id
     * @return 受影响的行数
     */
    Integer confirmReceipt(@Param("id") Integer id, @Param("modifiedTime") Date modifiedTime);

    /**
     * 系统确认支付状态
     * @param oid 订单商品id
     * @param paytime 订单支付时间
     * @return
     */
    Integer confirmPay(@Param("oid") Integer oid,@Param("paytime") Date paytime);

    /**
     * 修改已支付订单中商品状态为待发货
     * @param oid 订单id
     * @return
     */
    Integer changeStatusOfItem(@Param("oid") Integer oid);

    /**
     * 修改订单状态
     * @param oid 订单ｏｉｄ
     * @return
     */
    Integer changeStatusOfOrder(Integer oid);

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
    Integer setCommentStatus(Integer id);
}