package com.scut.cts.controller;

import com.scut.cts.dto.RespBean;
import com.scut.cts.dto.Url;
import com.scut.cts.service.UserService;
import com.scut.cts.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RequestMapping
@RestController
public class AvatarController
{
	@Autowired
	private UserService userService;

	@PostMapping("/upload")
	public RespBean uploadPicture(@RequestParam("avatar") MultipartFile avatar, @RequestParam String userId) throws Exception {
		if (null == avatar) {
			return RespBean.unprocessable("未上传头像文件");
		}
		String path = userService.uploadAvatar(avatar, userId);
		if (path==null){
			return RespBean.unprocessable("上传头像失败");
		}
		return RespBean.ok("信息修改成功",new Url(path));
	}
}
