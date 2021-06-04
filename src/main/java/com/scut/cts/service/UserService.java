package com.scut.cts.service;

import com.scut.cts.pojo.User;

public interface UserService {
	boolean register(User user);
	boolean login(User user);
	boolean updateUser(User user);
	boolean blockUser(String userId);
	boolean unblockUser(String userId);
	boolean deleteUser(String userId);
}
