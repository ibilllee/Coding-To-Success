package com.scut.cts.service.Impl;

import com.scut.cts.mapper.CommentMapper;
import com.scut.cts.mapper.UserMapper;
import com.scut.cts.dto.StatusAndToken;
import com.scut.cts.pojo.User;
import com.scut.cts.service.UserService;
import com.scut.cts.utils.MD5Utils;
import com.scut.cts.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private CommentMapper commentMapper;

	@Override
	public boolean register(User user) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		user.setPassword(MD5Utils.encodeByMd5(user.getPassword()));
		return userMapper.insert(user)==1;
	}

	@Override
	public StatusAndToken login(User user) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		String password = user.getPassword();
		user.setPassword(MD5Utils.encodeByMd5(user.getPassword()));
		User result = userMapper.selectByUserIdAndPassword(user);
		if(result == null)	return null;
		return new StatusAndToken(result.getStatus(),TokenUtils.getToken(user.getUserId(),password));
	}

	@Override
	public boolean updateUser(User user) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		user.setPassword(MD5Utils.encodeByMd5(user.getPassword()));
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
