package com.example.restdemo.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.restdemo.exception.UserNotFoundByIdException;
import com.example.restdemo.utility.ErrorStructure;
import com.example.restdemo.utility.ResponseBuilder;

@RestControllerAdvice
public class UserExceptionHandler {
	
	private ResponseBuilder errorResponseBuilder;
	
	
	public UserExceptionHandler(ResponseBuilder errorResponseBuilder) {
		super();
		this.errorResponseBuilder = errorResponseBuilder;
	}


	@ExceptionHandler(UserNotFoundByIdException.class)
	public ResponseEntity<ErrorStructure> handlerUserNotFoundById(UserNotFoundByIdException ex) {
		return errorResponseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(), "user not found by given id!!");
	}
}
