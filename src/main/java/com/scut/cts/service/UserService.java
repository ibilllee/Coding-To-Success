package com.scut.cts.service;

public interface UserService {
	public boolean blockUser(String userId);
	public boolean unblockUser(String userId);
	public boolean deleteUser(String userId);
}
