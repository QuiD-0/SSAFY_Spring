package com.ssafy.happyhouse.model.mapper;

import com.ssafy.happyhouse.model.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
	List<UserDto> getAllUsers();
	UserDto getUserById(String id);
	void registerUser(UserDto user);
	void updateUser(UserDto user);
	void deleteUser(String id);
	UserDto loginUser(Map<String, String> userInfo);
	
}
