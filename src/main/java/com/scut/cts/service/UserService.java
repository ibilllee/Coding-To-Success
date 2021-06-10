package com.scut.cts.service;

import com.scut.cts.dto.StatusAndToken;
import com.scut.cts.pojo.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public interface UserService {
	boolean register(User user) throws UnsupportedEncodingException, NoSuchAlgorithmException;
	StatusAndToken login(User user) throws UnsupportedEncodingException, NoSuchAlgorithmException;
	boolean updateUser(User user) throws UnsupportedEncodingException, NoSuchAlgorithmException;
	String uploadAvatar(MultipartFile avatar, String userId) throws Exception;
	boolean blockUser(String userId);
	boolean unblockUser(String userId);
	boolean deleteUser(String userId);
}
