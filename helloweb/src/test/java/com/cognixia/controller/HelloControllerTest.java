package com.cognixia.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cognixia.model.Hello;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void sayHello() throws Exception
	{
		mockMvc.perform(
				MockMvcRequestBuilders.get("/v1/hello"))
		.andExpect(status().isOk())
		.andExpect(content().string("Hello"));
	}
	
	@Test
	public void sayHelloObjasXML() throws Exception
	{
		mockMvc.perform(
				MockMvcRequestBuilders.get("/v1/helloobj")
				.accept(MediaType.APPLICATION_XML_VALUE))
		.andExpect(status().isOk());
	}
	
	@Test
	public void sayHelloObjasJSON() throws Exception
	{
		Hello hello = new Hello();
		hello.setDone(true);
		hello.setId(30);
		hello.setMessage("Hi from Controller");
		
		ObjectMapper om = new ObjectMapper();
		
		mockMvc.perform(
				MockMvcRequestBuilders.get("/v1/helloobj")
				.accept(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(status().isOk())
		.andExpect(content().json(om.writeValueAsString(hello)));
	}

}
