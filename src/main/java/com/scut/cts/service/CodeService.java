package com.scut.cts.service;

import com.scut.cts.pojo.Code;

public interface CodeService {
	public boolean saveCode(Code code);
	public Code getCode(String userId,String passwordId);
}
