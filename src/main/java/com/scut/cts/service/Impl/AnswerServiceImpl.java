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

	@Override
	public boolean addAnswer(Answer answer) {
		return answerMapper.insert(answer)==1;
	}

	@Override
	public boolean deleteAnswer(Integer probId) {
		return answerMapper.deleteByPrimaryKey(probId)==1;
	}

	@Override
	public boolean updateAnswer(Answer answer) {
		return answerMapper.updateByPrimaryKey(answer)==1;
	}
}
