package com.scut.cts.pojo;

import lombok.Data;

import java.util.List;

@Data
public class ResponseObj {
	private List<Object> data;
	private meta metaInfo;

}

