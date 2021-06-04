package com.scut.cts.service.Impl;

import com.scut.cts.pojo.UserCode;
import com.scut.cts.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class CodeServiceImpl implements CodeService {
	@Autowired
	private RedisTemplate redisTemplate;

	@Override
	public boolean saveCode(UserCode userCode) {
		String key= userCode.getUserId()+"@"+ userCode.getProbId();
		redisTemplate.boundValueOps(key).set(userCode.getCode(),1, TimeUnit.HOURS);
		return true;
	}

	@Override
	public UserCode getCode(String userId, int probId) {
		String key=userId+"@"+probId;
		String code=(String) redisTemplate.boundValueOps(key).get();
		return new UserCode(code,userId,probId);
	}
}
