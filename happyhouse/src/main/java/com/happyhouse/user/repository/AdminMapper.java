package com.happyhouse.user.repository;

import com.happyhouse.user.domain.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {
    List<UserDto> getAllAdmins();

    UserDto getAdminsById(String id);

    void registerAdmins(UserDto user);

    void updateAdmins(UserDto user);

    void deleteAdmins(String id);
}
