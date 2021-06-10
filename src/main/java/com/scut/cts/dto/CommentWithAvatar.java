package com.scut.cts.dto;

import com.scut.cts.pojo.Comment;
import lombok.Data;

@Data
public class CommentWithAvatar extends Comment
{
	private String commentAvatar;

	public CommentWithAvatar(Comment comment, String commentAvatar) {
		super(comment.getCommentTutoId(), comment.getCommentUserId(),comment.getContent() ,
				comment.getReplyTo(), comment.getReplyOrder());
		this.commentAvatar = commentAvatar;
	}

	public CommentWithAvatar(Comment comment) {
		super(comment.getCommentTutoId(), comment.getCommentUserId(),comment.getContent() ,
				comment.getReplyTo(), comment.getReplyOrder());
	}
}
