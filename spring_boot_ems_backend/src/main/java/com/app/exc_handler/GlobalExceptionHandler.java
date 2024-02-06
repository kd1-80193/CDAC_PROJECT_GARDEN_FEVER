package com.app.exc_handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.custom_exceptions.ResourceNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	/*
	 * if id not found in service controller then 
	 * orElseThrow method throw here i will give response
	 */

	@ExceptionHandler(ResourceNotFoundException.class)
	public String HandleResourceNotFoundException(ResourceNotFoundException ex) {
		
		return ex.getMessage();
		
		
	}
}
