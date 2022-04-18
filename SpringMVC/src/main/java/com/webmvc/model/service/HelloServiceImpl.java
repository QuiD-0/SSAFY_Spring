package com.webmvc.model.service;

import com.webmvc.model.HelloDto;
import com.webmvc.model.dao.HelloDao;

public class HelloServiceImpl implements HelloService {

	private HelloDao helloDao;
	
	@Override
	public HelloDto greeting() {
		HelloDto helloDto = new HelloDto();
		helloDto.setMessage(helloDao.greeting());
		return helloDto;
	}

}