package com.scau.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

//收藏夹的实体类
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Favorite extends BaseEntity implements Serializable {
    private Integer fid; //收藏夹fid
    private Integer uid; //用户uid
    private Integer pid; //收藏夹对应商品的uid;
}
