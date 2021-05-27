package com.scut.cts.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Table;

@Data
@Table(name = "test")
public class Test
{
	@Id
	@KeySql(useGeneratedKeys = true)
	private int id;

	private String name;

}
