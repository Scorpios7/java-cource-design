package com.scau.shop.mapper;

import com.scau.shop.entity.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CommentMapperTest {

    @Autowired
    private  CommentMapper commentMapper;

//    @Test
//    void addComment(){
//        Comment comment=new Comment();
//        comment.setUsername("123");
//        comment.setText("好啊");
//        //comment.setPid("4");
//        commentMapper.addComment(comment);
//    }
}
