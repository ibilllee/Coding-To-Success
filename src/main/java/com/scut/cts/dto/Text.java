package com.scut.cts.dto;

import lombok.Data;

@Data
public class Text
{
	private String text;

	public Text(String text) {
		this.text = text;
	}
}
