package com.scau.shop.Controller;

import com.scau.shop.entity.Product;
import com.scau.shop.service.ProductService;
import com.scau.shop.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

////处理商品相关请求的控制器
@RestController
@RequestMapping("/products")
public class ProductController extends BaseController{
    @Autowired
    private ProductService productService;

    @RequestMapping("/hot_list")
    public JsonResult<List<Product>>findHotList(){
        List<Product> data = productService.findHotList();
        return new JsonResult<List<Product>>(OK,data);
    }

    @RequestMapping("/{id}/details")
    public JsonResult<Product>findById(@PathVariable("id") Integer id){
        Product data = productService.findById(id);
        return new JsonResult<Product>(OK,data);
    }

    @RequestMapping("/new_list")
    public JsonResult<List<Product>>findNewList(){
        List<Product> data = productService.findNewList();
        return new JsonResult<List<Product>>(OK,data);
    }

    @RequestMapping("/search/{search}")
    public JsonResult<List<Product>> searchProduct(@PathVariable("search") String title){
        List<Product> data = productService.searchProduct(title);
        return new JsonResult<List<Product>>(OK,data);
    }
}
