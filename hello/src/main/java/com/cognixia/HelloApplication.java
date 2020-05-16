package com.cognixia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cognixia.model.MyHello;

@SpringBootApplication
public class HelloApplication implements CommandLineRunner{
	
	@Autowired
	MyHello hello;
	
	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = SpringApplication.run(HelloApplication.class, args);
		
		System.out.println("Beans count:" +context.getBeanDefinitionCount());
		
		String[] beans = context.getBeanDefinitionNames();
		
		for (String bean : beans) {
			System.out.println(bean);
		}
		
		System.out.println("Hello MasterClass!");
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("=============");
		System.out.println(hello.getMsg());
		System.out.println("=============");
	}

}

