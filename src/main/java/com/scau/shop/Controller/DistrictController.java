package com.scau.shop.Controller;

import com.scau.shop.entity.District;
import com.scau.shop.service.DistrictService;
import com.scau.shop.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//处理省市区相关请求的控制器
@RestController
@RequestMapping("/districts")
public class DistrictController extends BaseController{
    @Autowired
    private DistrictService districtService;

    @RequestMapping({"", "/"}) //“/”表示方法将处理所有传入的URI请求
    public JsonResult<List<District>>findByParent(String parent){
        //调用业务层的findByParent方法得到list
        List<District> data = districtService.findByParent(parent);
        return new JsonResult<List<District>>(OK,data);
    }
}
