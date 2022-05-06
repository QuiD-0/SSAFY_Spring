package com.ssafy.happyhouse.model.service;

import com.ssafy.happyhouse.model.UserDto;

import java.util.List;

public interface UserService {
	List<UserDto> getAllUsers() throws Exception;
	UserDto getUserById(String id) throws Exception;
	void registerUser(UserDto user) throws Exception;
	void updateUser(UserDto user) throws Exception;
	void deleteUser(String id) throws Exception;
	UserDto loginUser(String id, String password);
}
