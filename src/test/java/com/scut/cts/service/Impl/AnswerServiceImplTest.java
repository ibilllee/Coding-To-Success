package com.scut.cts.service.Impl;

import com.scut.cts.pojo.Answer;
import com.scut.cts.service.AnswerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnswerServiceImplTest {
	@Autowired
	private AnswerService answerService;

	@Test
	public void getAnswer(){
		System.out.println(answerService.getAnswer(1));
	}
}