package com.example.restdemo.mapper;

import org.springframework.stereotype.Component;


import com.example.restdemo.entity.User;
import com.example.restdemo.requestdto.UserRequest;
import com.example.restdemo.responsedto.UserResponse;

@Component
public class UserMapper {
	
	public User mapUserToEntity(UserRequest userRequest,User user) {
		user.setUsername(userRequest.getUsername());
		user.setEmail(userRequest.getEmail());
		user.setPassword(userRequest.getPassword());
		
		return user;
	}
	


	public UserResponse mapUserToResponse(User user) {
		UserResponse userResponse=new UserResponse();
		userResponse.setUser_id(user.getUser_id());
		userResponse.setUsername(user.getUsername());
		userResponse.setEmail(user.getEmail());
		return userResponse;
	}
	
}
