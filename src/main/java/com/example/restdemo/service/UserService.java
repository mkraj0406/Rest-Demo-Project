package com.example.restdemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.restdemo.entity.User;
import com.example.restdemo.exception.UserNotFoundByIdException;
import com.example.restdemo.mapper.UserMapper;
import com.example.restdemo.repository.UserRepository;
import com.example.restdemo.requestdto.UserRequest;
import com.example.restdemo.responsedto.UserResponse;

@Service
public class UserService {

	private UserRepository userRepository;

	private UserMapper userMapper;

	public UserService(UserRepository userRepository, UserMapper userMapper) {
		super();
		this.userRepository = userRepository;
		this.userMapper = userMapper;
	}

	public UserResponse saveUser(UserRequest userRequest) {
		User user = userMapper.mapUserToEntity(userRequest, new User());
		user = userRepository.save(user);

		UserResponse userResponse = userMapper.mapUserToResponse(user);
		return userResponse;
	}

	public UserResponse findUserById(int user_id) {
		
		//Functional way to write code
		UserResponse userResponse=  userRepository.findById(user_id)
		 .map(user -> userMapper.mapUserToResponse(user))
		 .orElseThrow(() -> new UserNotFoundByIdException("failed to find the user"));
		
		return userResponse;
		
//		Optional<User> optional = userRepository.findById(user_id);
//		if (optional.isPresent()) {
//			User user = optional.get();
//			UserResponse userResponse = userMapper.mapUserToResponse(user);
//			return userResponse;
//		}
//		else {
//			throw new UserNotFoundByIdException("failed to find the user!!");
//		}
	}

	public UserResponse updateUser(UserRequest userRequest, int user_id) {
		UserResponse userResponse =userRepository.findById(user_id).map(user -> {
			user = userMapper.mapUserToEntity(userRequest, user);
			user = userRepository.save(user);
			return userMapper.mapUserToResponse(user);
			
		}).orElseThrow(() -> new UserNotFoundByIdException("Failed to update user"));
		
		return userResponse;
//		Optional<User> optional = userRepository.findById(user_id);
//		if (optional.isPresent()) {
//			User user = userMapper.mapUserToEntity(userRequest, optional.get());
//			user = userRepository.save(user);
//			UserResponse userResponse = userMapper.mapUserToResponse(user);
//			return userResponse;
//
//		} else {
//			throw new UserNotFoundByIdException("failed to Update the user!!");
//		}
	}

	public UserResponse deleteUser(int user_id) {
		return userRepository.findById(user_id).map(user -> {
			User exUser = user;
			userRepository.delete(user);
			return userMapper.mapUserToResponse(exUser);
		}).orElseThrow(() -> new UserNotFoundByIdException("Not deleted"));
		
	
		
//		Optional<User> optional = userRepository.findById(user_id);
//		if (optional.isPresent()) {
//			User user = optional.get();
//			userRepository.delete(user);
//			UserResponse userResponse = userMapper.mapUserToResponse(user);
//			return userResponse;
//		} else {
//			throw new UserNotFoundByIdException("failed to deletes the user!!");
//		}
	}

	public List<UserResponse> findAllUser() {
		
		 return userRepository.findAll()
		.stream()
		.filter(user -> user.getUsername() != null)
		.map(user -> userMapper.mapUserToResponse(user))
		.toList();
		
		
		//Using foreach
//		List<UserResponse> userResponses = new ArrayList<UserResponse>();
//		userRepository.findAll().forEach(user -> {
//			UserResponse userResponse = userMapper.mapUserToResponse(user);
//			userResponses.add(userResponse);
//			
//		});
//		return userResponses;
		
		
//		List<User> users = userRepository.findAll();
//		if (users != null) {
//			List<UserResponse> userResponses = new ArrayList<UserResponse>();
//			for (User user : users) {
//				UserResponse userResponse = userMapper.mapUserToResponse(user);
//				userResponses.add(userResponse);
//			}
//
//			return userResponses;
//		} else {
//			throw new UserNotFoundByIdException("failed to dispaly the user!!");
//		}
	}

}
