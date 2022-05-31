package com.scau.shop.service.impl;

import com.scau.shop.entity.Comment;
import com.scau.shop.entity.Product;
import com.scau.shop.mapper.CommentMapper;
import com.scau.shop.service.CommentService;
import com.scau.shop.service.ex.InsertException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public void addComment(Comment comment){
        Integer rows=commentMapper.addComment(comment);
        if(rows!=1)throw new InsertException("添加评论时出现了未知错误，请联系系统管理员！");
    }

    @Override
    public List<Comment> showComment(Integer pid){
        List<Comment> list = commentMapper.showComment(pid);
        return list;
    }
}
