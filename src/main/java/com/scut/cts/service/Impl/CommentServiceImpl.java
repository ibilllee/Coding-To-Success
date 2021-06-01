package com.scut.cts.service.Impl;

import com.scut.cts.mapper.CommentMapper;
import com.scut.cts.pojo.Comment;
import com.scut.cts.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentMapper commentMapper;

	@Override
	public List<Comment> getComments(int tutoId) {
		return commentMapper.selectByTutoId(tutoId);
	}

	@Override
	public boolean addComment(Comment comment) {
		return commentMapper.insert(comment)==1;
	}

	@Override
	public int getReplyCount(int tutoId, int commentId) {
		return commentMapper.getReplyCount(tutoId, commentId);
	}
}
