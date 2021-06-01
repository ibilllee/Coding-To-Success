package com.scut.cts.service;

import com.scut.cts.pojo.Comment;

import java.util.List;

public interface CommentService {
	public List<Comment> getComments(int tutoId);
	public boolean addComment(Comment comment);
	public int getReplyCount(int tutoId,int commentId);
}