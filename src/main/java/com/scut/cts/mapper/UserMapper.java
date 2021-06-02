package com.scut.cts.mapper;

import com.scut.cts.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<User> {
	@Select("SELECT status FROM user WHERE user_id = #{userId}")
	public int selectStatusByUserId(String userId);
}
