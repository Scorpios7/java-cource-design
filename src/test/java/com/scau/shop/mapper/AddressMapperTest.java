package com.scau.shop.mapper;

import com.scau.shop.entity.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AddressMapperTest {
    @Autowired
    AddressMapper addressMapper;

//    @Test
//    public void addAddress() {
//        Address address = new Address();
//        address.setUid(16);
//        address.setName("lim");
//        address.setPhone("12131");
//        address.setAddress("农业大学");
//        Integer rows = addressMapper.addAddress(address);
//        if (rows == 1) {
//            System.err.println("添加成功");
//            System.err.println(address);
//        }
//    }
//
//    @Test
//    public void getAddressByuid() {
//        List<Address> list = addressMapper.getAddressByUid(16);
//        System.out.println(list);
//    }
//
//    @Test
//    public void updateNonDefaultByUid() {
//        Integer rows = addressMapper.updateNonDefaultByUid(16);
//        if (rows >= 1) System.err.println("更新成功！");
//    }
//
//    @Test
//    public void updateDefaultByAid() {
//        Integer rows = addressMapper.updateDefaultByAid(1, new Date());
//        if (rows == 1) System.err.println("更新成功！");
//    }
//
//    @Test
//    public void deleteAddress() {
//        Integer aid = 2;
//        Integer rows = addressMapper.deleteAddress(aid);
//        if (rows == 1) System.err.println("删除成功！");
//    }
//
//    @Test
//    public void findAddressByAid(){
//        Integer aid = 7;
//        Address address = addressMapper.findAddressByAid(aid);
//        System.err.println(address);
//    }
//
//    @Test
//    public void updateAddress(){
//        Address address = new Address();
//        address.setProvinceName(null);
//        address.setAid(1);
//        address.setAddress("123");
//        address.setPhone("123");
//        address.setModifiedTime(new Date());
//        addressMapper.updateAddress(address);
//    }
}