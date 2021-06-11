package com.scut.cts.dto;

import com.scut.cts.pojo.User;
import lombok.Data;

@Data
public class UserWithAvatar
{
	private String userId;
	private String token;
	private Integer status;
	private String avatar;

	public UserWithAvatar(User user,String token){
		userId=user.getUserId();
		this.token=token;
		status=user.getStatus();
		avatar=user.getHeadAddress();
	}
}
