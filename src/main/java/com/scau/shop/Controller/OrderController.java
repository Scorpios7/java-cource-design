package com.scau.shop.Controller;

import com.scau.shop.entity.Order;
import com.scau.shop.entity.OrderItem;
import com.scau.shop.entity.Product;
import com.scau.shop.service.OrderService;
import com.scau.shop.service.ex.InsertException;
import com.scau.shop.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController extends BaseController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/create")
    public JsonResult<Order> insertOrder(Integer aid, Integer[] cids, HttpSession session) {
        if(aid==null) throw new InsertException("您还未添加收货地址！");
        if(cids==null) throw new InsertException("您还A未勾选任何商品");
        Integer uid = getUidFromSession(session);
        Order data = orderService.insertOrder(aid, cids, uid);
        return new JsonResult<Order>(OK, data);
    }

    @RequestMapping("/create_single")
    public JsonResult<Order> insertSingleProductOrder(Integer aid, Integer num,
                                                      Integer id, HttpSession session) {
        if(aid==null) throw new InsertException("您还未添加收货地址！");
        Integer uid = getUidFromSession(session);
//        System.err.println("aid="+aid);
//        System.err.println("num="+num);
//        System.err.println("id="+id);
        Order data = orderService.insertSingleProductOrder(aid, num, id, uid);
        return new JsonResult<>(OK,data);
    }

    @RequestMapping("/get_all_orders")
    public JsonResult<List<Order>> findAllOrderVoByUid(HttpSession session) {
        Integer uid = getUidFromSession(session);
        //找到所有订单
        List<Order> data = orderService.findAllOrderByUid(uid);
        return new JsonResult<>(OK, data);
    }

    @RequestMapping("/get_wait_for_pay_orders")
    public JsonResult<List<Order>> findWaitForPayOrderVoByUid(HttpSession session) {
        Integer uid = getUidFromSession(session);
        //找到待付款订单
        List<Order> data = orderService.findWaitForPayOrderByUid(uid);
        return new JsonResult<>(OK, data);
    }

    @RequestMapping("/confirm_receipt/{itemId}")
    public JsonResult<Void> ConfirmReceipt(@PathVariable("itemId") Integer id) {
        orderService.confirmReceipt(id);
        return new JsonResult<Void>(OK);
    }

    @RequestMapping("/get_orderItems/{oid}")
    public JsonResult<List<OrderItem>> findOrderItemByOid(@PathVariable("oid") Integer oid) {
        List<OrderItem> data = orderService.findOrderItemByOid(oid);
        return new JsonResult<List<OrderItem>>(OK, data);
    }

    @RequestMapping("/get_wait_for_receive_orderItems")
    public JsonResult<List<OrderItem>> findNoReceiveOrderItem(HttpSession session) {
        Integer uid = getUidFromSession(session);
        List<OrderItem> data = orderService.findNoReceiveOrderItem(uid);
        return new JsonResult<>(OK, data);
    }

    @RequestMapping("/get_wait_for_comment_orderItems")
    public JsonResult<List<OrderItem>> findNoCommentOrderItem(HttpSession session) {
        Integer uid = getUidFromSession(session);
        List<OrderItem> data = orderService.findNoCommentOrderItem(uid);
        return new JsonResult<>(OK, data);
    }

    @RequestMapping("/get_order/{oid}")
    public JsonResult<Order> getOrderByOid(@PathVariable("oid") Integer oid) {
        Order data = orderService.getOrderByOid(oid);
        return new JsonResult<>(OK, data);
    }

    @RequestMapping("/confirm_pay/{oid}")
    public JsonResult<Void> ConfirmPay(@PathVariable("oid") Integer oid, String password) {
        orderService.confirmPay(oid, password);
        return new JsonResult<Void>(OK);
    }

    @RequestMapping("/get_finished_orderItems")
    public JsonResult<List<OrderItem>> findFinishedOrderItem(HttpSession session) {
        Integer uid = getUidFromSession(session);
        List<OrderItem> data = orderService.findFinishedOrderItem(uid);
        return new JsonResult<>(OK, data);
    }
}
