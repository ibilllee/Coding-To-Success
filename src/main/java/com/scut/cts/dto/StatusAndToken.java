package com.scut.cts.dto;

import lombok.Data;

@Data
public class StatusAndToken
{
	private Integer status;
	private String token;

	public StatusAndToken(Integer status, String token) {
		this.status = status;
		this.token = token;
	}
}
