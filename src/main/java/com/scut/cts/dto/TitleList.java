package com.scut.cts.dto;

import lombok.Data;

import java.util.List;

@Data
public class TitleList
{
	private List<TitleContent> titleContentList;
	public TitleList(List<TitleContent> titleContentList) {
		this.titleContentList = titleContentList;
	}

}
