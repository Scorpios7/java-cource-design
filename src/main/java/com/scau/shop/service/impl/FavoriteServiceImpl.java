package com.scau.shop.service.impl;

import com.scau.shop.entity.Favorite;
import com.scau.shop.mapper.FavoriteMapper;
import com.scau.shop.service.FavoriteService;
import com.scau.shop.service.ex.FavoriteExsistedException;
import com.scau.shop.service.ex.InsertException;
import com.scau.shop.vo.FavoriteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FavoriteServiceImpl implements FavoriteService {
    @Autowired
    private FavoriteMapper favoriteMapper;

    @Override
    public void addFavorite(Favorite favorite) {
        Favorite result = favoriteMapper.findByUidAndPid(favorite.getUid(), favorite.getPid());
        if(result!=null) throw new FavoriteExsistedException("该商品已在收藏夹");
        Date date = new Date();
        favorite.setCreatedTime(date);
        favorite.setModifiedTime(date);
        Integer rows = favoriteMapper.addFavorite(favorite);
        if(rows!=1) throw new InsertException("添加收藏夹时出现了未知错误，请联系系统管理员！");
    }

    @Override
    public List<FavoriteVO> findVoByuid(Integer uid) {
        return favoriteMapper.findVoByuid(uid);
    }

    @Override
    public void cancelByFid(Integer fid) {
        favoriteMapper.cancelByFid(fid);
    }
}
