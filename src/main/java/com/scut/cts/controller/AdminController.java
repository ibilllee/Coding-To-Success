package com.scut.cts.controller;

import com.scut.cts.pojo.Admin;
import com.scut.cts.pojo.RespBean;
import com.scut.cts.service.AdminService;
import com.scut.cts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping
@RestController
public class AdminController
{
	@Autowired
	private UserService userService;

	@Autowired
	private AdminService adminService;

	@PostMapping("/admin/login")
	public RespBean login(@RequestParam String adminId, @RequestParam String password) {
		Admin admin = new Admin(adminId, password);
		boolean result;
		try {
			result = adminService.login(admin);
		}catch (Exception e) {
			return RespBean.unprocessable("管理员登录失败");
		}
		if(result) {
			return RespBean.ok("管理员登录成功");
		}
		return RespBean.unprocessable("管理员登录失败");
	}

	@PutMapping("/adminId/:AdminId")
	public RespBean updateAdmin(@RequestParam String adminId, @RequestParam String password) {
		Admin admin = new Admin(adminId,password);
		boolean result;
		try {
			result = adminService.updateAdmin(admin);
		}catch (Exception e) {
			return RespBean.unprocessable("密码修改失败"+e.getMessage());
		}
		if(result) {
			return RespBean.ok("密码修改成功");
		}
		return RespBean.unprocessable("密码修改失败");
	}

	@DeleteMapping("/user")
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

	@PutMapping("/user/ban")
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

	@PutMapping("/user/unban")
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
