package com.scut.cts.service.Impl;

import com.scut.cts.pojo.Code;
import com.scut.cts.service.CodeService;
import org.springframework.stereotype.Service;

@Service
public class CodeServiceImpl implements CodeService {

	@Override
	public boolean saveCode(Code code) {
		return false;
	}

	@Override
	public Code getCode(String userId, String passwordId) {
		return null;
	}
}
