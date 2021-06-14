package com.scut.cts.mapper;

import com.scut.cts.dto.UserAndStatus;
import com.scut.cts.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {
	@Select("SELECT status FROM user WHERE user_id = #{userId}")
	int selectStatusByUserId(String userId);

	@Select("SELECT * FROM user WHERE user_id = #{userId} and password = #{password}")
	User selectByUserIdAndPassword(User user);

	@Update("UPDATE user SET head_address = #{headAddress} WHERE user_id = #{userId}")
	int updateHeadAddressByUserId(String headAddress,String userId);

	@Select("SELECT head_address FROM user WHERE user_id = #{userId}")
	String selectHeadAddressByUserId(String userId);

	@Select("SELECT user_id,status From user WHERE user_id <> 'CLOSED_ACCOUNT'")
	List<UserAndStatus> selectUserIdAndStatus();
}
