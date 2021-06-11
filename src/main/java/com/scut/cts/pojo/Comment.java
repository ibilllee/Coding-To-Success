package com.scut.cts.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.*;

@Data
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;
    private Integer commentTutoId;
    private String commentUserId;
    private String content;
    private Integer replyTo;
    private Integer replyOrder;

    public Comment() {
    }

    public Comment(Integer commentTutoId, String commentUserId, String content, Integer replyTo, Integer replyOrder) {
        this.commentTutoId = commentTutoId;
        this.commentUserId = commentUserId;
        this.content = content;
        this.replyTo = replyTo;
        this.replyOrder = replyOrder;
    }

    public Comment(Integer commentId, Integer commentTutoId, String commentUserId, String content, Integer replyTo, Integer replyOrder) {
        this.commentId = commentId;
        this.commentTutoId = commentTutoId;
        this.commentUserId = commentUserId;
        this.content = content;
        this.replyTo = replyTo;
        this.replyOrder = replyOrder;
    }
}
