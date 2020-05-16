package com.cognixia.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cognixia.model.Todo;
import com.cognixia.model.Todos;
import com.cognixia.service.TodoService;



@RestController
@RequestMapping("/v2/todos")
public class TodoController {

	@Autowired
	TodoService todoService;

	@Cacheable("todos")
	@GetMapping
	public ResponseEntity<Todos> getTodos() {

		// return ResponseEntity.ok(todoService.getTodos());

		HttpHeaders responseHeaders = new HttpHeaders();
		//	responseHeaders.setLocation(location);
		responseHeaders.set("MyResponseHeader", "MyValue");
		
		return new ResponseEntity<Todos>(new Todos(todoService.getTodos()), responseHeaders, HttpStatus.OK);

	}

	@GetMapping("/todo/{id}")
	public Todo getTodoById(@PathVariable int id) {
		return todoService.getTodoById(id);
	}

	@GetMapping("/{user}")
	public List<Todo> getTodosByUser(@PathVariable String user) {
		return todoService.getTodosByUser(user);
	}

	@PostMapping
	public ResponseEntity<Todo> updateTodo(@Valid @RequestBody Todo todo) {

		Todo result = todoService.addTodo(todo);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/todo/{id}").buildAndExpand(result.getId())
				.toUri();
		return ResponseEntity.created(location).build();

	}

	@PutMapping("/{id}")
	public Todo updateTodo(@PathVariable int id,@Valid @RequestBody Todo todo) {

		if (todo.getId() == 0) {
			todo.setId(id);
		}
		return todoService.updateTodo(todo);
	}

	@DeleteMapping("/{id}")
	public boolean deleteTodo(@PathVariable int id) {
		return todoService.deleteTodoById(id);
	}

}
