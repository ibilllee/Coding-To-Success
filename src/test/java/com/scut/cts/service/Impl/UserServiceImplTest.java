package com.scut.cts.service.Impl;

import com.scut.cts.pojo.User;
import com.scut.cts.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {
	@Autowired
	private UserService userService;

	@Test
	public void register() throws UnsupportedEncodingException, NoSuchAlgorithmException {
		System.out.println(userService.register(new User("AAA","123456")));
	}

	@Test
	public void login() throws UnsupportedEncodingException, NoSuchAlgorithmException {
		System.out.println(userService.login(new User("user","user")));
	}

	@Test
	public void updateUser() throws UnsupportedEncodingException, NoSuchAlgorithmException {
		System.out.println(userService.updateUser(new User(null, "111111")));
	}

	@Test
	public void blockUser(){
		userService.blockUser("user");
	}

	@Test
	public void unblockUser(){
		userService.unblockUser("user");
	}

	@Test
	public void deleteUser(){
		userService.deleteUser("user");
	}
}