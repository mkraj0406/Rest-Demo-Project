package com.example.restdemo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.restdemo.entity.User;
import com.example.restdemo.requestdto.UserRequest;
import com.example.restdemo.responsedto.UserResponse;
import com.example.restdemo.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class UserController {
	
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	
	
	@Operation(description = "The API endpoint is used to save the User"
			, responses = {
					@ApiResponse(responseCode = "201", description = "User Created"),
					@ApiResponse(responseCode = "500",description = "Internal Server Error",
						content = {
								@Content(schema = @Schema(anyOf = RuntimeException.class))
								
						}
							)
			})
	@PostMapping("/users")
	public ResponseEntity<UserResponse> saveUser( @RequestBody UserRequest userRequest) {
		UserResponse userResponse= userService.saveUser(userRequest);//Here we reassigned the user
		return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
	}
	
	@GetMapping("/users/{user_id}")
	public ResponseEntity<UserResponse> findUserById(@PathVariable int user_id) {
	UserResponse userResponse = userService.findUserById(user_id);	
	return ResponseEntity.status(HttpStatus.FOUND).body(userResponse);
	}
	
	@PutMapping("/users/{user_id}")
	public ResponseEntity<UserResponse> updateUser(@RequestBody UserRequest userRequest, @PathVariable int user_id) {
		UserResponse userResponse =  userService.updateUser(userRequest,user_id);
		return ResponseEntity.status(HttpStatus.OK).body(userResponse);
	}
	
	@DeleteMapping("/users/{user_id}")
	public ResponseEntity<UserResponse> deleteUser(@PathVariable int user_id) {
		UserResponse userResponse =  userService.deleteUser(user_id);
		return ResponseEntity.status(HttpStatus.OK).body(userResponse);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<UserResponse>> findAllUser() {
		List<UserResponse> userResponses= userService.findAllUser();
		return ResponseEntity.status(HttpStatus.FOUND).body(userResponses);
	}
	
	
}
