package com.scau.shop.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

//收藏夹的Value Object类
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteVO implements Serializable {
    private Integer fid;
    private Integer uid;
    private Integer pid;
    private Long price;
    private String title;
    private String image;
}
