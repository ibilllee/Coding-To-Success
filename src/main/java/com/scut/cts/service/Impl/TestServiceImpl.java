package com.scut.cts.service.Impl;

import com.scut.cts.pojo.Test;
import com.scut.cts.mapper.TestMapper;
import com.scut.cts.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService
{
	@Autowired
	private TestMapper testMapper;

	@Override
	public Test add(Test test) {
		return testMapper.insert(test) == 1 ? testMapper.selectByName(test.getName()) : null;
	}
}
