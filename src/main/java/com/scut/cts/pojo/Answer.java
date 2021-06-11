package com.scut.cts.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "answer")
public class Answer {
	@Id
	private Integer ansProbId;
	private String content;

	public Answer(Integer ansProbId, String content) {
		this.ansProbId = ansProbId;
		this.content = content;
	}

	public Answer() {
	}
}
