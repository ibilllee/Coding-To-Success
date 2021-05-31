package com.scut.cts.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "test")
public class Test
{
	@Id
	@KeySql(useGeneratedKeys = true)
	private Integer id;

	private String name;

}
