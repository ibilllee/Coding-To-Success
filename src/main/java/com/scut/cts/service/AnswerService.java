package com.scut.cts.service;

import com.scut.cts.pojo.Answer;

public interface AnswerService {
	Answer getAnswer(int probId);
	boolean addAnswer(Answer answer);
	boolean deleteAnswer(Integer probId);
	boolean updateAnswer(Answer answer);
}
