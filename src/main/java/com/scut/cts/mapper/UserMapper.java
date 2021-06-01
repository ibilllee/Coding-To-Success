package com.scut.cts.mapper;

import com.scut.cts.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<User> {
	@Update("UPDATE user SET password = #{password} WHERE user_id = #{userId}")
	public int updatePasswordByUserId(User user);

	@Update("UPDATE user SET status = #{status} WHERE user_id = #{userId}")
	public int updateStatusByUserId(User user);

	@Select("SELECT status FROM user WHERE user_id = #{userId}")
	public int selectStatusByUserId(String userId);
}
