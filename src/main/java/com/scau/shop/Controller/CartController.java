package com.scau.shop.Controller;

import com.scau.shop.entity.Address;
import com.scau.shop.service.CartService;
import com.scau.shop.util.JsonResult;
import com.scau.shop.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController extends BaseController{
    @Autowired
    private CartService cartService;

    @RequestMapping("/add_to_cart")
    public JsonResult<Void>addCart(Integer pid, Integer amount, HttpSession session){
        Integer uid = getUidFromSession(session);
        cartService.addCart(uid,pid,amount);
        return new JsonResult<Void>(OK);
    }

    @RequestMapping({"","/"})
    public JsonResult<List<CartVO>>findVOByUid(HttpSession session){
        Integer uid = getUidFromSession(session);
        List<CartVO> data = cartService.findVOByUid(uid);
        return new JsonResult<List<CartVO>>(OK,data);
    }

    @RequestMapping("/{cid}/num/add")
    public JsonResult<Integer>addNum(@PathVariable("cid") Integer cid){
        Integer data = cartService.addNum(cid);
        return new JsonResult<Integer>(OK,data);
    }

    @RequestMapping("/{cid}/num/reduce")
    public JsonResult<Integer>reduceNum(@PathVariable("cid") Integer cid){
        Integer data = cartService.reduceNum(cid);
        return new JsonResult<Integer>(OK,data);
    }

    @RequestMapping("/list")
    public JsonResult<List<CartVO>>findVOByCids(Integer[] cids){
        List<CartVO> data = cartService.findVOByCids(cids);
        return new JsonResult<List<CartVO>>(OK,data);
    }

    @RequestMapping("/{cid}/delete")
    public JsonResult<Void>deleteByCid(@PathVariable("cid") Integer cid){
        cartService.deleteByCid(cid);
        return new JsonResult<Void>(OK);
    }
}
