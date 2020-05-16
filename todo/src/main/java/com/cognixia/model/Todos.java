package com.cognixia.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Todos {

	private List<Todo> todos;

	public List<Todo> getTodos() {
		return todos;
	}

	public void setTodos(List<Todo> todos) {
		this.todos = todos;
	}
	
	public Todos() {
		// TODO Auto-generated constructor stub
	}
	
	public Todos(List<Todo> todos) {
		this.todos = todos;
	}
	
}
