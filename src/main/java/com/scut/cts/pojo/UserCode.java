package com.scut.cts.pojo;

import lombok.Data;

@Data
public class UserCode
{
	private String code;
	private String userId;
	private Integer probId;

	public UserCode(){}

	public UserCode(String code, String userId, Integer probId) {
		this.code = code;
		this.userId = userId;
		this.probId = probId;
	}
}
