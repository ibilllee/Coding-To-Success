package com.scut.cts.mapper;

import com.scut.cts.entity.Test;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface TestMapper extends Mapper<Test>
{
	@Select("SELECT * FROM test WHERE id = (SELECT MAX(id) FROM test)")
	Test selectByName(String name);
}
