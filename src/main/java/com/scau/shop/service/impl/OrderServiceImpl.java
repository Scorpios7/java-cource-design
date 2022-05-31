package com.scau.shop.service.impl;

import com.scau.shop.entity.Address;
import com.scau.shop.entity.Order;
import com.scau.shop.entity.OrderItem;
import com.scau.shop.entity.Product;
import com.scau.shop.mapper.CartMapper;
import com.scau.shop.mapper.OrderMapper;
import com.scau.shop.mapper.ProductMapper;
import com.scau.shop.service.AddressService;
import com.scau.shop.service.OrderService;
import com.scau.shop.service.ex.InsertException;
import com.scau.shop.service.ex.PasswordNotMatchException;
import com.scau.shop.service.ex.UpdateException;
import com.scau.shop.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private AddressService addressService;

    @Override
    public Order insertOrder(Integer aid, Integer[] cids, Integer uid) {
        Date date = new Date();
        // 根据cids查询所勾选的购物车列表中的数据
        List<CartVO> carts = cartMapper.findVOByCids(cids);

        //查询收货地址
        Address address = addressService.findAddressByAid(aid);

        //计算这些商品的总价
        long totalPrice = 0;
        for (CartVO cart : carts) {
            totalPrice += cart.getRealPrice() * cart.getNum();
        }

        //创建订单对象
        Order order = new Order();
        //补全数据
        order.setUid(uid);
        order.setOrderTime(date);  //下单时间
        order.setRecvName(address.getName());
        order.setRecvPhone(address.getPhone());
        order.setRecvProvince(address.getProvinceName());
        order.setRecvCity(address.getCityName());
        order.setRecvArea(address.getAreaName());
        order.setRecvAddress(address.getAddress());
        order.setTotalPrice(totalPrice);
        order.setCreatedTime(date);
        order.setModifiedTime(date);
        order.setStatus(0);
        //插入订单
        Integer rows = orderMapper.insertOrder(order);
        if (rows != 1) {
            throw new InsertException("插入订单数据时出现未知错误，请联系系统管理员");
        }

        //遍历carts，循环插入订单商品数据
        for (CartVO cart : carts) {
            OrderItem item = new OrderItem();
            item.setOid(order.getOid());
            item.setPid(cart.getPid());
            item.setTitle(cart.getTitle());
            item.setImage(cart.getImage());
            item.setCreatedTime(date);
            item.setModifiedTime(date);
            item.setPrice(cart.getRealPrice());
            item.setNum(cart.getNum());
            item.setStatus(0);
            item.setUid(uid);
            //插入订单商品数据
            rows = orderMapper.insertOrderItem(item);
            if (rows != 1) {
                throw new InsertException("插入订单商品数据时出现未知错误，请联系系统管理员");
            }
        }
        return order;
    }

    @Override
    public Order insertSingleProductOrder(Integer aid, Integer num, Integer id, Integer uid) {
        //先获取地址对象
        Address address = addressService.findAddressByAid(aid);

        Date date = new Date();
        Product product = productMapper.findById(id);
        //总价格
        Long totalPrice = product.getPrice()*num;
        //创建订单对象
        Order order = new Order();
        //补全数据
        order.setUid(uid);
        order.setOrderTime(date);  //下单时间
        order.setRecvName(address.getName());
        order.setRecvPhone(address.getPhone());
        order.setRecvProvince(address.getProvinceName());
        order.setRecvCity(address.getCityName());
        order.setRecvArea(address.getAreaName());
        order.setRecvAddress(address.getAddress());
        order.setTotalPrice(totalPrice);
        order.setCreatedTime(date);
        order.setModifiedTime(date);
        order.setStatus(0);

        //插入订单数据
        Integer rows = orderMapper.insertOrder(order);
        if (rows != 1) {
            throw new InsertException("插入订单数据时出现未知错误，请联系系统管理员");
        }

        //插入订单商品数据
        OrderItem item = new OrderItem();
        item.setOid(order.getOid());
        item.setPid(product.getId());
        item.setTitle(product.getTitle());
        item.setImage(product.getImage());
        item.setCreatedTime(date);
        item.setModifiedTime(date);
        item.setPrice(product.getPrice());
        item.setNum(num);
        item.setStatus(0);
        item.setUid(uid);
        //插入订单商品数据
        rows = orderMapper.insertOrderItem(item);
        if (rows != 1) {
            throw new InsertException("插入订单商品数据时出现未知错误，请联系系统管理员");
        }
        return order;
    }

    @Override
    public List<Order> findAllOrderByUid(Integer uid) {
        //先通过uid找到所有的订单
        List<Order> orders = orderMapper.findAllOrderByUid(uid);
        return orders;
    }

    @Override
    public List<Order> findWaitForPayOrderByUid(Integer uid) {
        //先通过uid找到所有的订单
        List<Order> orders = orderMapper.findAllOrderByUid(uid);
        List<Order> list = new ArrayList<>();
        for (Order order : orders) {
            if (order.getStatus() != 0) continue;
            list.add(order);
        }
        return list;
    }

    @Override
    public void confirmReceipt(Integer id) {
        orderMapper.confirmReceipt(id, new Date());
    }

    @Override
    public void confirmPay(Integer oid,String password) {
        if (password.equals("123456") == false)
            throw new PasswordNotMatchException("密码错误，请输入正确密码");
        Integer row = orderMapper.confirmPay(oid,new Date());
        Integer rows = orderMapper.changeStatusOfItem(oid);
        Integer r = orderMapper.changeStatusOfOrder(oid);
        if(row != 1)throw new UpdateException("支付失败，请联系管理员");
        if(rows == 0 )throw new UpdateException("支付失败，请联系管理员");
        if(r == 0 )throw new UpdateException("支付失败，请联系管理员");
    }

    @Override
    public List<OrderItem> findOrderItemByOid(Integer oid) {
        List<OrderItem> list = orderMapper.findOrderItemByOid(oid);
        return list;
    }

    @Override
    public List<OrderItem> findNoReceiveOrderItem(Integer uid) {
        return orderMapper.findNoReceiveOrderItem(uid);
    }

    @Override
    public List<OrderItem> findNoCommentOrderItem(Integer uid) {
        return orderMapper.findNoCommentOrderItem(uid);
    }

    @Override
    public Order getOrderByOid(Integer oid) {
        return orderMapper.getOrderByOid(oid);
    }

    @Override
    public void setCommentStatus(Integer id) {
        orderMapper.setCommentStatus(id);
    }

    @Override
    public List<OrderItem> findFinishedOrderItem(Integer uid) {
        return orderMapper.findFinishedOrderItem(uid);
    }
}
