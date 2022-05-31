package com.scau.shop.service.impl;

import com.scau.shop.entity.District;
import com.scau.shop.service.DistrictService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DistrictServiceImplTest {
    @Autowired
    private DistrictService districtService;

//    @Test
//    public void findByParent(){
//        String parent = "110100";
//        List<District> list = districtService.findByParent(parent);
//        System.out.println(list);
//    }
//
//    @Test
//    public void findNameByCode(){
//        String code = "540000";
//        System.err.println(districtService.findNameByCode(code));
//    }
}