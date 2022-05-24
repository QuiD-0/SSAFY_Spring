package com.happyhouse.user.service;

import com.happyhouse.user.domain.UserDto;
import com.happyhouse.user.repository.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<UserDto> getAllAdmin() throws Exception {
        return adminMapper.getAllAdmins();
    }

    @Override
    public UserDto getAdminById(String id) throws Exception {
        return adminMapper.getAdminsById(id);
    }

    @Override
    public void registerAdmin(UserDto user) throws Exception {
        adminMapper.registerAdmins(user);
    }

    @Override
    public void updateAdmin(UserDto user) throws Exception {
        adminMapper.updateAdmins(user);
    }

    @Override
    public void deleteAdmin(String id) throws Exception {
        adminMapper.deleteAdmins(id);
    }
}
