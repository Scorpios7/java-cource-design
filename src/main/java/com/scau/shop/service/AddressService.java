package com.scau.shop.service;

import com.scau.shop.entity.Address;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AddressService {
    /**
     * 增加收货地址
     *
     * @param uid     uid通过session获得
     * @param address address对象通过前端获得
     */
    void addAddress(Integer uid, Address address);

    /**
     * 查询用户的收货地址列表数据
     *
     * @param uid
     * @return 返回用户的收货地址列表
     */
    List<Address> getAddressByUid(Integer uid);

    /**
     * 将用户的某条收货地址设置为默认地址
     * @param aid 某条地址的aid
     * @param uid uid,用来将所有收货地址设置为非默认地址
     * @return 返回值为受影响的行数
     */
    void updateDefaultByAid(Integer aid, Integer uid);

    /**
     * 删除某条收货地址
     * @param aid 地址的aid，通过前端发送到后端
     */
    void deleteAddress(Integer aid);

    /**
     * 通过aid找到收货地址，并把没用的字段设为null
     * @param aid
     * @return
     */
    Address findAddressByAid(Integer aid);

    /**
     * 修改收货地址信息
     * @param address 地址对象
     */
    void updateAddress(Integer uid,Address address);
}
