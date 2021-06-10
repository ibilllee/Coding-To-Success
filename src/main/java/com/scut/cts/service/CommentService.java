package com.scut.cts.service;

import com.scut.cts.dto.CommentWithAvatar;
import com.scut.cts.pojo.Comment;

import java.util.List;

public interface CommentService {
	List<CommentWithAvatar> getComments(int tutoId);
	boolean addComment(Comment comment);
	int getReplyCount(int tutoId, int commentId);
}