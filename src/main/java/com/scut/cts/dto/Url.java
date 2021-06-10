package com.scut.cts.dto;

import lombok.Data;

@Data
public class Url
{
	private String url;

	public Url(String url) {
		this.url = url;
	}
}
