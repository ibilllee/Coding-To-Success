package com.scut.cts.pojo;

import lombok.Data;

@Data
public class Code
{
	private String code;
	private Integer probId;

	public Code() {
	}

	public Code(String code, Integer probId) {
		this.code = code;
		this.probId = probId;
	}
}
