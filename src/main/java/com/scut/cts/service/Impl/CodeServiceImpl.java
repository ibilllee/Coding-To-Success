package com.scut.cts.service.Impl;

import com.scut.cts.pojo.Code;
import com.scut.cts.service.CodeService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class CodeServiceImpl implements CodeService {
	@Autowired
	private RedisTemplate redisTemplate;

	@Override
	public boolean saveCode(Code code) {
		String key=code.getUserId()+"@"+code.getProbId();
		redisTemplate.boundValueOps(key).set(code.getCode(),1, TimeUnit.HOURS);
		return true;
	}

	@Override
	public Code getCode(String userId, int probId) {
		String key=userId+"@"+probId;
		String code=(String) redisTemplate.boundValueOps(key).get();
		return new Code(code,userId,probId);
	}
}
