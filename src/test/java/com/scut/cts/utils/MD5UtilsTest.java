package com.scut.cts.utils;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MD5UtilsTest
{
	@Test
	public void generate() throws UnsupportedEncodingException, NoSuchAlgorithmException {
		//System.out.println(MD5Utils.encodeByMd5("user"));
	}
}