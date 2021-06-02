package com.scut.cts.service.Impl;

import com.scut.cts.mapper.AnswerMapper;
import com.scut.cts.pojo.Answer;
import com.scut.cts.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService {
	@Autowired
	private AnswerMapper answerMapper;

	@Override
	public Answer getAnswer(int probId) {
		return answerMapper.selectByPrimaryKey(probId);
	}


}
