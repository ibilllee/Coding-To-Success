package com.scut.cts.service;

public interface UserService {
	boolean blockUser(String userId);
	boolean unblockUser(String userId);
	boolean deleteUser(String userId);
}
