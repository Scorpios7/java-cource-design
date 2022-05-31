package com.scau.shop.mapper;

import com.scau.shop.entity.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

//处理收货地址数据的持久层接口
@Mapper
public interface AddressMapper {
    /**
     * 添加收货地址
     * @param address  //address对象
     * @return  //返回值为受影响的行数
     */
    Integer addAddress(Address address);

    /**
     * 查询某用户的收货地址列表数据
     * @param uid 收货地址归属的用户id
     * @return 该用户的收货地址列表数据
     */
    List<Address> getAddressByUid(Integer uid);

    /**
     * 将某用户的所有地址设置为非默认地址
     * @return 返回值为受影响的行数
     */
    Integer updateNonDefaultByUid(Integer uid);

    /**
     * 将用户的某条收货地址设为为默认地址
     * @param aid  某条收货地址的aid
     * @param modifiedTime 修改时间
     * @return 返回值为受影响的行数
     */
    Integer updateDefaultByAid(@Param("aid") Integer aid,
                               @Param("modifiedTime") Date modifiedTime);

    /**
     * 删除某条收货地址
     * @param aid  地址的aid
     * @return  返回值为受影响的行数
     */
    Integer deleteAddress(Integer aid);

    /**
     * 通过aid找到收货地址
     * @param aid
     * @return
     */
    Address findAddressByAid(Integer aid);

    /**
     * 修改收货地址信息
     * @param address Address对象
     * @return 受影响的行数
     */
    Integer updateAddress(Address address);
}
