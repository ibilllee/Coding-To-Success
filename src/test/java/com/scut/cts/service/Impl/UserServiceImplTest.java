package com.scut.cts.service.Impl;

import com.scut.cts.pojo.User;
import com.scut.cts.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {
	@Autowired
	private UserService userService;
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