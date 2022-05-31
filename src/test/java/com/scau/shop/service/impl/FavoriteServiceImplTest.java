package com.scau.shop.service.impl;

import com.scau.shop.entity.Favorite;
import com.scau.shop.service.FavoriteService;
import com.scau.shop.vo.FavoriteVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class FavoriteServiceImplTest {
    @Autowired
    private FavoriteService favoriteService;

//    @Test
//    void addFavorite(){
//        Favorite favorite = new Favorite();
//        favorite.setUid(16);
//        favorite.setPid(10000013);
//        favorite.setCreatedTime(new Date());
//        favorite.setModifiedTime(new Date());
//        favoriteService.addFavorite(favorite);
//    }
//
//    @Test
//    void findVoByuid(){
//        List<FavoriteVO> vos = favoriteService.findVoByuid(16);
//        for (FavoriteVO vo : vos) {
//            System.err.println(vo);
//        }
//    }
//
//    @Test
//    void cancelByFid(){
//        favoriteService.cancelByFid(1);
//    }
}