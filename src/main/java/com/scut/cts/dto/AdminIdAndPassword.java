package com.scut.cts.dto;

import lombok.Data;

@Data
public class AdminIdAndPassword
{
	private String adminId;
	private String password;

	public AdminIdAndPassword(String adminId, String password) {
		this.adminId = adminId;
		this.password = password;
	}
}
