package com.scut.cts.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TokenUtilsTest
{
	@Test
	public void generateToken(){
		String token = TokenUtils.getToken("user", "user");
		System.out.println(token);
	}

}