package com.cognixia.advice;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TodoControllerAdvice {

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<?> todoNotFound(NoSuchElementException e)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
}
