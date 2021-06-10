package com.scut.cts.dto;

import lombok.Data;

@Data
public class Status
{
	private int status;

	public Status(int status) {
		this.status = status;
	}
}
