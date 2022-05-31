package com.scau.shop.service;

import com.scau.shop.entity.Comment;
import java.util.List;
public interface CommentService {

    /**
     * 添加评论
     * @param comment 评论对象
     */
    void addComment(Comment comment);

    /**
     *
     * @param pid
     * @return
     */
    List<Comment> showComment(Integer pid);
}
