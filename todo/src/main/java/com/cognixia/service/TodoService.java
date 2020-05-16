package com.cognixia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognixia.model.Todo;
import com.cognixia.repository.TodoRepository;

@Service
public class TodoService {

	@Autowired
	TodoRepository todorepo;

	public List<Todo> getTodos() {
		return todorepo.findAll();
	}

	public List<Todo> getTodosByUser(String user)
	{
		return todorepo.findByUser(user);
	}

	public Todo getTodoById(Integer id) {
		return todorepo.findById(id).orElseThrow();
	}

	public Todo addTodo(Todo todo) {
		return todorepo.save(todo);
	}

	public Todo updateTodo(Todo todo) {
		if (getTodoById(todo.getId()) != null)
			return todorepo.save(todo);
		else
			return null;
	}

	public boolean deleteTodoById(Integer id) {
		if (getTodoById(id) != null) {
			todorepo.deleteById(id);
			return true;
		} else
			return false;
	}

}
