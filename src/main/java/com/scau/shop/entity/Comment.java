package com.scau.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment extends BaseEntity implements Serializable {
    private Integer cid;
    private Integer pid;
    private String username;
    private String text;
}
