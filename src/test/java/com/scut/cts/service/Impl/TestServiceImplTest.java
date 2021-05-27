package com.scut.cts.service.Impl;

import com.scut.cts.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestServiceImplTest
{
	@Autowired
	private TestService testService;

	@Test
	public void insert(){
		com.scut.cts.entity.Test test = new com.scut.cts.entity.Test();
		test.setName("app");
		testService.add(test);
	}
}