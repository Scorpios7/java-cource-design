package com.scau.shop.Controller;

import com.scau.shop.entity.Favorite;
import com.scau.shop.service.FavoriteService;
import com.scau.shop.util.JsonResult;
import com.scau.shop.vo.FavoriteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

//收藏夹的controller类
@RestController
@RequestMapping("/favorite")
public class FavoriteController extends BaseController{
    @Autowired
    private FavoriteService favoriteService;

    @RequestMapping("/add")
    public JsonResult<Void>addFavorite(Integer pid, HttpSession session){
        Integer uid = getUidFromSession(session);
        Favorite favorite = new Favorite();
        favorite.setPid(pid);
        favorite.setUid(uid);
        favoriteService.addFavorite(favorite);
        return new JsonResult<Void>(OK);
    }

    @RequestMapping({"/",""})
    public JsonResult<List<FavoriteVO>> findVoByuid(HttpSession session){
        Integer uid = getUidFromSession(session);
        List<FavoriteVO> data = favoriteService.findVoByuid(uid);
        return new JsonResult<List<FavoriteVO>>(OK,data);
    }

    @RequestMapping("/cancel/{fid}")
    public JsonResult<Void>cancelByFid(@PathVariable("fid") Integer fid){
        favoriteService.cancelByFid(fid);
        return new JsonResult<Void>(OK);
    }
}
