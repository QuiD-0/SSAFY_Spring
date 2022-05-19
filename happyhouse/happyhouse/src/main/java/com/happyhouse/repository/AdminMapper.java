package com.happyhouse.repository;

import com.happyhouse.domain.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdminMapper {
	List<UserDto> getAllAdmins();
	UserDto getAdminsById(String id);
	void registerAdmins(UserDto user);
	void updateAdmins(UserDto user);
	void deleteAdmins(String id);
}
