package com.scut.cts.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "answer")
public class Answer {
	@Id
	private Integer ansProbId;

	private String content;
}
