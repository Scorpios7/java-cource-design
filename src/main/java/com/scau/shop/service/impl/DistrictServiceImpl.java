package com.scau.shop.service.impl;

import com.scau.shop.entity.District;
import com.scau.shop.mapper.DistrictMapper;
import com.scau.shop.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictMapper districtMapper;

    @Override
    public List<District> findByParent(String parent) {
        List<District> list = districtMapper.findByParent(parent);
        //将id和parent设为null，这两个值在后续的操作中没用，设为null以提升传输效率
        for (District district : list) {
            district.setId(null);
            district.setParent(null);
        }
        return list;
    }

   /* @Override
    public String findNameByCode(String code) {
        return districtMapper.findNameByCode(code);
    }*/
}
