package com.scau.shop.Controller;

import com.scau.shop.entity.Address;
import com.scau.shop.service.AddressService;
import com.scau.shop.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

//处理收货地址相关请求的控制器
@RestController
@RequestMapping("/addresses")
public class AddressController extends BaseController {
    @Autowired
    private AddressService addressService;

    @RequestMapping("/add_new_address")
    public JsonResult<Void> addAddress(HttpSession session, Address address) {
        //从session中获取uid
        Integer uid = getUidFromSession(session);

        //调用业务层的addAddress方法
        addressService.addAddress(uid, address);
        //响应成功
        return new JsonResult<Void>(OK);
    }

    @RequestMapping({"", "/"})
    public JsonResult<List<Address>> getAddressByUid(HttpSession session) {
        Integer uid = getUidFromSession(session);
        List<Address> data = addressService.getAddressByUid(uid);
        return new JsonResult<List<Address>>(OK, data);
    }

    @RequestMapping("/{aid}/set_default")
    public JsonResult<Void> updateDefaultByAid(HttpSession session,
                                               @PathVariable("aid") Integer aid) {
        Integer uid = getUidFromSession(session);
        addressService.updateDefaultByAid(aid,uid);
        return new JsonResult<Void>(OK);
    }

    @RequestMapping("/{aid}/delete")
    public JsonResult<Void>deleteAddress(@PathVariable("aid") Integer aid){
        addressService.deleteAddress(aid);
        return new JsonResult<Void>(OK);
    }

    @RequestMapping("/{aid}/update")
    public JsonResult<Void>updateAddress(Address address,HttpSession session,
                                         @PathVariable("aid") Integer aid){
        address.setAid(aid);
        Integer uid = getUidFromSession(session);
        addressService.updateAddress(uid,address);
        return new JsonResult<Void>(OK);
    }

    @RequestMapping("/{aid}/find")
    public JsonResult<Address>findAddressByAid(@PathVariable("aid") Integer aid){
        Address data = addressService.findAddressByAid(aid);
        return new JsonResult<Address>(OK,data);
    }
}
