package com.scau.shop.mapper;

import com.scau.shop.entity.District;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DistrictMapperTest {
    @Autowired
    private DistrictMapper districtMapper;

//    @Test
//    public void findByParent(){
//        String parent = "110100";
//        List<District> list = districtMapper.findByParent(parent);
//        System.out.println(list);
//    }
//
//    @Test
//    public void findNameByCode(){
//        String code = "540000";
//        String name = districtMapper.findNameByCode(code);
//        System.err.println(name);
//    }
}