package com.cognixia.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.model.Hello;

@RestController
@RequestMapping("/v1")
public class HelloController {

	@GetMapping("hello")
	public String sayHello()
	{
		return "Hello";
	}
	
	@GetMapping("helloname")
	public String sayHelloByName(@RequestParam String name)
	{
		return "Hello "+ name;
	}
	
	@GetMapping("hello/{name}")
	public String sayHello(@PathVariable String name)
	{
		return "Hello "+ name;
	}
	@GetMapping("hello/{name}/{id}")
	public String sayHello(@PathVariable String name, @PathVariable int id)
	{
		return "Hello "+ name + " With ID:"+ id;
	}
	
	@GetMapping( 
			value = "helloobj", 
			produces = {
					MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE
			})
	public Hello sayHelloByObj()
	{
		Hello hello = new Hello();
		hello.setDone(true);
		hello.setId(30);
		hello.setMessage("Hi from Controller");
		
		return hello;
	}
	
	@PostMapping( 
			value = "helloobj", 
			produces = {
					MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE
			},
			consumes = {
					MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE
			})
	public Hello sayHelloByObj(@RequestBody Hello hello)
	{	
		System.out.println(hello.getId());
		return hello;
	}
}

