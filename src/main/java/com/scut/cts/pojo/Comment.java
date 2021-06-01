package com.scut.cts.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name="comment")
public class Comment {
	@Id
	@KeySql(useGeneratedKeys = true)
	private Integer commentId;
	private Integer commentTutoId;
	private String commentUserId;
	private String content;
	private Integer replyTo;
	private Integer replyOrder;

	public Comment(){ }

	public Comment(Integer commentTutoId, String commentUserId, String content, Integer replyTo, Integer replyOrder) {
		this.commentTutoId = commentTutoId;
		this.commentUserId = commentUserId;
		this.content = content;
		this.replyTo = replyTo;
		this.replyOrder = replyOrder;
	}
}
