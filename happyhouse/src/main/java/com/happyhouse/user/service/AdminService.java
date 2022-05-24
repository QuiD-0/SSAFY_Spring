package com.happyhouse.user.service;

import com.happyhouse.user.domain.UserDto;

import java.util.List;

public interface AdminService {
    List<UserDto> getAllAdmin() throws Exception;

    UserDto getAdminById(String id) throws Exception;

    void registerAdmin(UserDto user) throws Exception;

    void updateAdmin(UserDto user) throws Exception;

    void deleteAdmin(String id) throws Exception;
}
