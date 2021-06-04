package com.scut.cts.service.Impl;

import com.scut.cts.mapper.CommentMapper;
import com.scut.cts.mapper.UserMapper;
import com.scut.cts.pojo.User;
import com.scut.cts.service.CommentService;
import com.scut.cts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private CommentMapper commentMapper;

	@Override
	public boolean register(User user) {
		return userMapper.insert(user)==1;
	}

	@Override
	public boolean login(User user) {
		User result = userMapper.selectOne(user);
		if(result == null)return false;
		return true;
	}

	@Override
	public boolean updateUser(User user) {
		return userMapper.updateByPrimaryKeySelective(user)==1;
	}

	@Override
	public boolean blockUser(String userId) {
		return userMapper.updateByPrimaryKeySelective(new User(userId,null,0))==1;
	}

	@Override
	public boolean unblockUser(String userId) {
		return userMapper.updateByPrimaryKeySelective(new User(userId,null,1))==1;
	}

	@Override
	public boolean deleteUser(String userId) {
		commentMapper.updateToClosedAccountByUserId(userId);
		return userMapper.deleteByPrimaryKey(userId)==1;
	}
}
