package com.scut.cts.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class HostConfig
{
	private static String address;

	@Value("${project.address}")
	public void setAddress(String address) {
		HostConfig.address = address;
	}

	public static String getAddress() {
		return address;
	}
}
