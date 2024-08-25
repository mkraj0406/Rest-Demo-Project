package com.example.restdemo.utility;

import org.springframework.http.ResponseEntity;

public class ErrorStructure {
	
	private int Status;
	private String message;
	private String rootCouse;
	
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getRootCouse() {
		return rootCouse;
	}
	public void setRootCouse(String rootCouse) {
		this.rootCouse = rootCouse;
	}
	
	public static ErrorStructure create(int status,String message,String rootCouse) {
		ErrorStructure errorStructure = new ErrorStructure();
		errorStructure.setStatus(status);
		errorStructure.setMessage(message);
		errorStructure.setRootCouse(rootCouse);
		
		return errorStructure; 
	}
	
}
