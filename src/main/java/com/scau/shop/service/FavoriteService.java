package com.scau.shop.service;

import com.scau.shop.entity.Favorite;
import com.scau.shop.vo.FavoriteVO;

import java.util.List;

//收藏夹的service类
public interface FavoriteService {
    /**
     * 添加商品到收藏夹
     * @param favorite 收藏夹对象
     */
    void addFavorite(Favorite favorite);

    /**
     * 查找用户收藏夹的VO类，并发送给前端
     * @param uid 用户uid
     * @return 返回FavoriteVo集合
     */
    List<FavoriteVO> findVoByuid(Integer uid);

    /**
     * 取消收藏
     * @param fid 收藏夹fid
     */
    void cancelByFid(Integer fid);
}
