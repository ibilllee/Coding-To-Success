package com.scut.cts.service;

import com.scut.cts.pojo.Code;

public interface CodeService {
	boolean saveCode(Code code);
	Code getCode(String userId, int probId);
}
