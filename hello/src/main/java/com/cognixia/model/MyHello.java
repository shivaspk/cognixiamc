package com.cognixia.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyHello {
	
	@Value("${message}")
	private String msg;
	
	public MyHello() {
		System.out.println("MyHello");
		System.out.println(msg);
	}

	public String getMsg() {
		return msg;
	}

	
}
