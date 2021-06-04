package com.scut.cts.service.Impl;

import com.scut.cts.pojo.UserCode;
import com.scut.cts.service.CodeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CodeServiceImplTest {
	@Autowired
	private CodeService codeService;

	@Test
	public void saveCode(){
		UserCode userCode = new UserCode("code", "user", 2);
		codeService.saveCode(userCode);
	}

	@Test
	public void getCode(){
		System.out.println(codeService.getCode("user",2));
	}
}