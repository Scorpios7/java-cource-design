package com.scau.shop.service.impl;

import com.scau.shop.entity.Cart;
import com.scau.shop.mapper.CartMapper;
import com.scau.shop.service.CartService;
import com.scau.shop.service.ex.DeleteException;
import com.scau.shop.service.ex.InsertException;
import com.scau.shop.service.ex.UpdateException;
import com.scau.shop.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartMapper cartMapper;

    @Override
    public void addCart(Integer uid, Integer pid, Integer amount) {
        //根据uid和pid查询购物车的数据，如果结果为null，则添加到购物车，否则更新购物车商品的num
        Cart result = cartMapper.findCartByUidAndPid(uid, pid);
        Date date = new Date();
        if(result==null){
            Cart cart = new Cart();
            cart.setUid(uid);
            cart.setPid(pid);
            cart.setNum(amount);
            cart.setCreatedTime(date);
            cart.setModifiedTime(date);
            Integer rows = cartMapper.addCart(cart);
            if(rows!=1){
                throw new InsertException("插入购物车数据时出现未知错误，请联系管理员");
            }
        }else{
            Integer num = result.getNum()+amount;
            Integer rows = cartMapper.updateNumByCid(result.getCid(),num,date);
            if(rows!=1){
                throw new UpdateException("更新购物车数据时出现未知错误，请联系管理员");
            }
        }
    }

    @Override
    public List<CartVO> findVOByUid(Integer uid) {
        List<CartVO> list = cartMapper.findVOByUid(uid);
        for (CartVO cartVO : list) {
            cartVO.setPrice(cartVO.getRealPrice());
        }
        return list;
    }

    @Override
    public Integer addNum(Integer cid) {
        Cart cart = cartMapper.findByCid(cid);
        Integer num = cart.getNum()+1;
        Integer rows = cartMapper.updateNumByCid(cid, num, new Date());
        if(rows!=1){
            throw new UpdateException("修改商品数量时出现未知错误，请联系系统管理员");
        }
        return num;
    }

    @Override
    public Integer reduceNum(Integer cid) {
        Cart cart = cartMapper.findByCid(cid);
        Integer num = cart.getNum()-1;
        Integer rows = cartMapper.updateNumByCid(cid, num, new Date());
        if(rows!=1){
            throw new UpdateException("修改商品数量时出现未知错误，请联系系统管理员");
        }
        return num;
    }

    @Override
    public List<CartVO> findVOByCids(Integer[] cids) {
        return cartMapper.findVOByCids(cids);
    }

    @Override
    public void deleteByCid(Integer cid) {
        Integer rows = cartMapper.deleteByCid(cid);
        if(rows!=1) throw new DeleteException("删除购物车时出现了未知错误，请联系系统管理员");
    }
}
