package com.scut.cts.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HostConfig
{
	private static String myAddress;
	private static String judgerAddress;

	@Value("${project.my-address}")
	public void setAddress(String address) {
		HostConfig.myAddress = address;
	}

	@Value("${project.judger-address}")
	public void setJudgerAddress(String judgerAddress) {
		HostConfig.judgerAddress = judgerAddress;
	}

	public static String getMyAddress() {
		return myAddress;
	}

	public static String getJudgerAddress() {
		return judgerAddress;
	}
}
