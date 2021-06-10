package com.scut.cts.dto;

import lombok.Data;

@Data
public class Code
{
	private String code;

	public Code(String code) {
		this.code = code;
	}
}
