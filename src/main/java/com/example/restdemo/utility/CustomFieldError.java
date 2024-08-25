package com.example.restdemo.utility;

public class CustomFieldError {

	private String fieldName;
	private String errorMessage;

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public static CustomFieldError create(String fieldName, String errorMessage) {
		CustomFieldError customFieldError = new CustomFieldError();
		customFieldError.setFieldName(fieldName);
		customFieldError.setErrorMessage(errorMessage);
		return customFieldError;
	}
	
	

}
