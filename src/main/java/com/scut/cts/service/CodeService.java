package com.scut.cts.service;

import com.scut.cts.pojo.UserCode;

public interface CodeService {
	boolean saveCode(UserCode userCode);
	UserCode getCode(String userId, int probId);
}
