package com.scut.cts.pojo;

import lombok.Data;

@Data
public class Code {
	private String code;
	private String userId;
	private Integer probId;

	public Code(){}

	public Code(String code, String userId, Integer probId) {
		this.code = code;
		this.userId = userId;
		this.probId = probId;
	}
}
