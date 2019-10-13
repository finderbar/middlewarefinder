package com.finder.middleware.service;

import org.springframework.stereotype.Service;

import com.finder.middleware.annotation.RMIServiceType;

@Service
@RMIServiceType(requestUrl = "/hello.service", serviceInterface = UserReadPlatformService.class, name = "hello2")
public class UserReadPlatformServiceImpl implements UserReadPlatformService{

	@Override
	public void hello() {
		System.out.println("hello world");
	}

}
