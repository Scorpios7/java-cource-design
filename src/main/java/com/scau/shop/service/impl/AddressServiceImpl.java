package com.scau.shop.service.impl;

import com.scau.shop.entity.Address;
import com.scau.shop.mapper.AddressMapper;
import com.scau.shop.mapper.DistrictMapper;
import com.scau.shop.service.AddressService;
import com.scau.shop.service.ex.CodeLengthLimitedException;
import com.scau.shop.service.ex.DeleteException;
import com.scau.shop.service.ex.InsertException;
import com.scau.shop.service.ex.UpdateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private DistrictMapper districtMapper;


    @Override
    public void addAddress(Integer uid, Address address) {
        //如果邮政编码长度大于6，则抛出异常
        if(address.getZip().length()>6){
            throw new CodeLengthLimitedException("邮政编码长度不得大于6！");
        }
        //调用持久层的findNameByCode方法获得省市区的名字
        String provinceName = districtMapper.findNameByCode(address.getProvinceCode());
        String cityName = districtMapper.findNameByCode(address.getCityCode());
        String areaName = districtMapper.findNameByCode(address.getAreaCode());
        //补全数据
        address.setProvinceName(provinceName);
        address.setCityName(cityName);
        address.setAreaName(areaName);
        address.setUid(uid);
        address.setIsDefault(0);
        Date date = new Date();
        address.setCreatedTime(date);
        address.setModifiedTime(date);

        //调用mapper层的addAddress方法
        Integer rows = addressMapper.addAddress(address);
        if(rows!=1){
            throw new InsertException("插入收货地址数据时出现未知错误，请联系系统管理员！");
        }
    }

    @Override
    public List<Address> getAddressByUid(Integer uid) {
        List<Address> list = addressMapper.getAddressByUid(uid);
        //将没用的值设置为null，提升传输效率
        for (Address address : list) {
            address.setUid(null);
            address.setModifiedTime(null);
            address.setCreatedTime(null);
            address.setAreaCode(null);
            address.setProvinceCode(null);
            address.setCityCode(null);
        }
        return list;
    }

    @Override
    public void updateDefaultByAid(Integer aid,Integer uid) {
        //先将所有收货地址设为非默认地址
        Integer rows = addressMapper.updateNonDefaultByUid(uid);
        if(rows<1){
            throw new UpdateException("设置默认收货地址时出现未知错误");
        }
        //将aid地址设置为默认地址
        rows = addressMapper.updateDefaultByAid(aid, new Date());
        if(rows!=1){
            throw new UpdateException("设置默认收货地址时出现未知错误");
        }
    }

    @Override
    public void deleteAddress(Integer aid) {
        Integer rows = addressMapper.deleteAddress(aid);
        if(rows!=1){
            throw new DeleteException("删除收货地址数据时出现未知错误，请联系系统管理员");
        }
    }

    @Override
    public Address findAddressByAid(Integer aid) {
        Address address = addressMapper.findAddressByAid(aid);
        //将没用的字段设为null
        address.setCreatedTime(null);
        address.setModifiedTime(null);
        return address;
    }

    @Override
    public void updateAddress(Integer uid,Address address) {
        //如果邮政编码长度大于6，则抛出异常
        if(address.getZip().length()>6){
            throw new CodeLengthLimitedException("邮政编码长度不得大于6！");
        }
        //调用持久层的findNameByCode方法获得省市区的名字
        String provinceName = districtMapper.findNameByCode(address.getProvinceCode());
        String cityName = districtMapper.findNameByCode(address.getCityCode());
        String areaName = districtMapper.findNameByCode(address.getAreaCode());
        //补全数据
        address.setProvinceName(provinceName);
        address.setCityName(cityName);
        address.setAreaName(areaName);
        address.setUid(uid);
        Date date = new Date();
        address.setModifiedTime(date);

        //调用mapper层的addAddress方法
        Integer rows = addressMapper.updateAddress(address);
        if(rows!=1){
            throw new UpdateException("修改收货地址数据时出现未知错误，请联系系统管理员！");
        }
    }
}
