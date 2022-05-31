package com.scau.shop.mapper;

import com.scau.shop.entity.Favorite;
import com.scau.shop.vo.FavoriteVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class FavoriteMapperTest {
    @Autowired
    private FavoriteMapper favoriteMapper;

//    @Test
//    void addFavorite(){
//        Favorite favorite = new Favorite();
//        favorite.setUid(16);
//        favorite.setPid(10000017);
//        favorite.setCreatedTime(new Date());
//        favorite.setModifiedTime(new Date());
//        favoriteMapper.addFavorite(favorite);
//    }
//
//    @Test
//    void findByUidAndPid(){
//        Favorite favorite = favoriteMapper.findByUidAndPid(16, 10000017);
//        System.err.println(favorite);
//    }
//
//    @Test
//    void findVoByuid(){
//        List<FavoriteVO> vos = favoriteMapper.findVoByuid(16);
//        for (FavoriteVO vo : vos) {
//            System.err.println(vo);
//        }
//    }
//
//    @Test
//    void cancelByFid(){
//        Integer rows = favoriteMapper.cancelByFid(4);
//        if(rows==1) System.err.println("success");
//    }
}