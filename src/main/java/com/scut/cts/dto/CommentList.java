package com.scut.cts.dto;

import com.scut.cts.pojo.Comment;

import java.util.List;

public class CommentList
{
	private List<CommentWithAvatar> commentList;
	public CommentList(List<CommentWithAvatar> commentList) {
		this.commentList = commentList;
	}
}
