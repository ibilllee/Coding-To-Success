package com.scut.cts.dto;

import lombok.Data;

@Data
public class meta {
	private String msg;
	private int status;

	public meta() {}

	public meta(String msg, int status) {
		this.msg = msg;
		this.status = status;
	}
}