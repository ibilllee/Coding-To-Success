package com.scut.cts.controller;

import com.scut.cts.pojo.RespBean;
import com.scut.cts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController
{
	@Autowired
	private UserService userService;

	@DeleteMapping
	public RespBean deleteUser(@RequestParam String userId){
		boolean result;
		try {
			result=userService.deleteUser(userId);
		}catch (Exception e){
			return RespBean.unprocessable("删除失败"+e.getMessage());
		}
		if (result)
			return RespBean.ok("删除成功");
		return RespBean.unprocessable("删除失败");
	}

	@PutMapping("/ban")
	public RespBean blockUser(@RequestParam String userId){
		boolean result;
		try {
			result=userService.blockUser(userId);
		}catch (Exception e){
			return RespBean.unprocessable("封禁失败"+e.getMessage());
		}
		if (result)
			return RespBean.ok("封禁成功");
		return RespBean.unprocessable("封禁失败");
	}

	@PutMapping("/unban")
	public RespBean unblockUser(@RequestParam String userId){
		boolean result;
		try {
			result=userService.unblockUser(userId);
		}catch (Exception e){
			return RespBean.unprocessable("解封失败"+e.getMessage());
		}
		if (result)
			return RespBean.ok("解封成功");
		return RespBean.unprocessable("解封失败");
	}
}
