package com.scut.cts.dto;

import lombok.Data;

@Data
public class UserIdAndPassword
{
	private String userId;
	private String password;

	public UserIdAndPassword(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}
}
