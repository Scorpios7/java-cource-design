package com.scau.shop.mapper;

import com.scau.shop.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface CommentMapper {

    /**
     * 增加评论
     * @param comment 评论对象
     * @return 受影响的行数
     */
    Integer addComment(Comment comment);

    /**
     * 显示商品有关评论
     * @param id 商品id
     * @return
     */
    List<Comment> showComment(Integer id);
}
