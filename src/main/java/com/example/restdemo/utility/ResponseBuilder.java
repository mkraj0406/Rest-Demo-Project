package com.example.restdemo.utility;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseBuilder {

		public  ResponseEntity<ErrorStructure> error(HttpStatus status,String message,String rootCouse) {
			return  ResponseEntity
					.status(status)
					.body(ErrorStructure.create(status.value(), message, rootCouse));
		}
		
		
		public <T> ResponseEntity<ResponseStructure<T>> success(HttpStatus status,String message,T data) {
			return ResponseEntity
					.status(status)
					.body(ResponseStructure.create(status, message, data));
		}
		
		
		public ResponseEntity<Object> fieldErrors(HttpStatus badRequest, String message, List<CustomFieldError> errors) {
			return ResponseEntity.status(badRequest)
			.body(ResponseStructure.create(badRequest, message, errors));
		}
		
}
