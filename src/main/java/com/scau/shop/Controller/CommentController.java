package com.scau.shop.Controller;

import com.scau.shop.entity.Comment;
import com.scau.shop.service.CommentService;
import com.scau.shop.service.OrderService;
import com.scau.shop.util.JsonResult;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController extends BaseController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private OrderService orderService;

    @RequestMapping("/add")
    public JsonResult<Void>addComment(Integer itemId,Integer id,
                                      String text, HttpSession session){
        String username = getUsernameFromSession(session);
        //Integer pid=getidFromSession(session);
        Date date=new Date();
        Comment comment=new Comment();
        comment.setPid(id);
        comment.setUsername(username);
        comment.setText(text);
        comment.setCreatedTime(date);
        commentService.addComment(comment);
        orderService.setCommentStatus(itemId); //将订单商品状态改为已完成
        return new JsonResult<Void>(OK);

    }

    @RequestMapping("/show/{id}")
    public JsonResult<List<Comment>> showComment(@PathVariable("id")Integer pid){
        List<Comment> data = commentService.showComment(pid);
        return new JsonResult<List<Comment>>(OK,data);
    }
}
