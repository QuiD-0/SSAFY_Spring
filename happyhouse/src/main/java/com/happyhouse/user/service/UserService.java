package com.happyhouse.user.service;

import com.happyhouse.user.domain.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers() throws Exception;

    UserDto getUserById(String id) throws Exception;

    void registerUser(UserDto user) throws Exception;

    void updateUser(UserDto user) throws Exception;

    void deleteUser(String id) throws Exception;

    UserDto loginUser(String id, String password);

    String findId(String name,String phone);

    boolean checkPassword(String id, String name);

    void changePW(UserDto userDto);
}
