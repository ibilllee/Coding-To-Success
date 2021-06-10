package com.scut.cts.dto;

import com.scut.cts.pojo.Comment;

import java.util.List;

public class CommentList
{
	private List<Comment> commentList;
	public CommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
}
