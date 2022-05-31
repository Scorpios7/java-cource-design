package com.scau.shop.Controller;

import com.scau.shop.entity.Product;
import com.scau.shop.service.AdminService;
import com.scau.shop.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController extends BaseController{
    @Autowired
    private AdminService adminService;

    @RequestMapping("/add_product")
    public JsonResult<Void>addProduct(Product product, List<MultipartFile> files){
        adminService.addProduct(product,files);
        return new JsonResult<>(OK);
    }
}
