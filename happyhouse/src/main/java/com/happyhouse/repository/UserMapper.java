package com.happyhouse.repository;

import com.happyhouse.domain.UserDto;
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

    void registerAdmin(Map<String, String> adminMap);

    void changePassword(Map<String, String> userMap);

    String checkID(Map<String, String> userMap);

    int checkPW(Map<String, String> userMap);

    void newPassword(UserDto userDto);
}
