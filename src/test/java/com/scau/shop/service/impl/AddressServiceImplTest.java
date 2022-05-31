package com.scau.shop.service.impl;

import com.scau.shop.entity.Address;
import com.scau.shop.service.AddressService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AddressServiceImplTest {
    @Autowired
    private AddressService addressService;

//    @Test
//    public void addAddress(){
//        try {
//            Integer uid = 16;
//            Address address = new Address();
//            address.setName("777");
//            address.setPhone("123");
//            address.setAddress("广州市番禺区");
//            addressService.addAddress(uid,address);
//            System.err.println("添加成功！");
//            System.err.println(address);
//        } catch (Exception e) {
//            System.err.println(e.getClass().getSimpleName());
//            System.err.println(e.getMessage());
//        }
//    }
//
//    @Test
//    public void getAddressByUid(){
//        List<Address> list = addressService.getAddressByUid(16);
//        for (Address address : list) {
//            System.err.println(address);
//        }
//    }
//
//    @Test
//    public void updateDefaultByAid(){
//        try {
//            addressService.updateDefaultByAid(2,16);
//        } catch (Exception e) {
//            System.err.println(e.getClass().getSimpleName());
//            System.err.println(e.getMessage());
//        }
//    }
//
//    @Test
//    public void deleteAddress(){
//        Integer aid = 4;
//        try {
//            addressService.deleteAddress(aid);
//            System.err.println("删除成功！");
//        } catch (Exception e) {
//            System.err.println(e.getClass().getSimpleName());
//            System.err.println(e.getMessage());
//        }
//    }
//
//    @Test
//    public void updateAddress(){
//        Address address = new Address();
//        address.setZip("111");
//        address.setAid(1);
//        address.setAddress("222222");
//        address.setPhone("222222");
//        address.setModifiedTime(new Date());
//        addressService.updateAddress(1,address);
//    }
}