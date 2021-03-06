package com.scut.cts.service;

import com.scut.cts.dto.UserAndStatus;
import com.scut.cts.dto.UserWithAvatar;
import com.scut.cts.pojo.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface UserService {
	boolean register(User user) throws UnsupportedEncodingException, NoSuchAlgorithmException;
	UserWithAvatar login(User user) throws UnsupportedEncodingException, NoSuchAlgorithmException;
	boolean updateUser(User user) throws UnsupportedEncodingException, NoSuchAlgorithmException;
	String uploadAvatar(MultipartFile avatar, String userId) throws Exception;
	List<UserAndStatus> getUserList();
	boolean blockUser(String userId);
	boolean unblockUser(String userId);
	boolean deleteUser(String userId);
}
