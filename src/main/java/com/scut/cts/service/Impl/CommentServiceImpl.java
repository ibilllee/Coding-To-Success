package com.scut.cts.service.Impl;

import com.scut.cts.config.HostConfig;
import com.scut.cts.dto.CommentWithAvatar;
import com.scut.cts.mapper.CommentMapper;
import com.scut.cts.mapper.UserMapper;
import com.scut.cts.pojo.Comment;
import com.scut.cts.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService
{
	@Autowired
	private CommentMapper commentMapper;

	@Autowired
	private UserMapper userMapper;

	@Override
	public List<CommentWithAvatar> getComments(Integer tutoId) {
		List<Comment> comments = commentMapper.selectByTutoId(tutoId);
		ArrayList<CommentWithAvatar> commentWithAvatars = new ArrayList<>();
		for (Comment comment : comments) {
			CommentWithAvatar commentWithAvatar = new CommentWithAvatar(comment);
			commentWithAvatar.setCommentAvatar(HostConfig.getAddress()+userMapper.selectHeadAddressByUserId(comment.getCommentUserId()));
			commentWithAvatars.add(commentWithAvatar);
		}
		return commentWithAvatars;
	}

	@Override
	public boolean addComment(Comment comment) {
		return commentMapper.insert(comment) == 1;
	}

	@Override
	public int getReplyCount(int tutoId, int commentId) {
		return commentMapper.getReplyCount(tutoId, commentId);
	}
}
