package com.scut.cts.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "bulletin")
public class Bulletin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bulletinId;
	private String content;

	public Bulletin(){}

	public Bulletin(String content) {
		this.content = content;
	}

	public Bulletin(Integer bulletinId, String content) {
		this.bulletinId = bulletinId;
		this.content = content;
	}
}
