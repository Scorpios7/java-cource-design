package com.scau.shop.mapper;

import com.scau.shop.entity.Favorite;
import com.scau.shop.vo.FavoriteVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FavoriteMapper {
    /**
     * 添加商品到收藏夹
     * @param favorite 收藏夹对象
     * @return 受影响的行数
     */
    Integer addFavorite(Favorite favorite);

    /**
     * 通过uid和pid查询该商品是否已在收藏夹
     * @param uid 用户uid
     * @param pid 商品pid
     * @return Favorite对象
     */
    Favorite findByUidAndPid(@Param("uid") Integer uid, @Param("pid") Integer pid);

    /**
     * 查找用户收藏夹的VO类，并发送给前端
     * @param uid 用户uid
     * @return 返回FavoriteVo集合
     */
    List<FavoriteVO> findVoByuid(Integer uid);

    /**
     * 取消收藏
     * @param fid 收藏夹fid
     * @return 受影响的行数
     */
    Integer cancelByFid(Integer fid);
}
