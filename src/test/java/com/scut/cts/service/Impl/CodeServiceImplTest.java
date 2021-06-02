package com.scut.cts.service.Impl;

import com.scut.cts.pojo.Code;
import com.scut.cts.service.CodeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CodeServiceImplTest {
	@Autowired
	private CodeService codeService;

	@Test
	public void saveCode(){
		Code code = new Code("code", "user", 2);
		codeService.saveCode(code);
	}

	@Test
	public void getCode(){
		System.out.println(codeService.getCode("user",2));
	}
}