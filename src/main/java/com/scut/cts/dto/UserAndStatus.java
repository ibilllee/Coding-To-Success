package com.scut.cts.dto;

import lombok.Data;

@Data
public class UserAndStatus
{
	private String userId;
	private Integer status;

	public UserAndStatus(String userId, Integer status) {
		this.userId = userId;
		this.status = status;
	}
}
