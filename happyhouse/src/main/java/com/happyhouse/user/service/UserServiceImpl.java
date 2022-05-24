package com.happyhouse.user.service;

import com.happyhouse.user.domain.UserDto;
import com.happyhouse.user.repository.UserMapper;
import com.happyhouse.util.Encrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDto> getAllUsers() throws Exception {
        return userMapper.getAllUsers();
    }

    @Override
    public UserDto getUserById(String id) throws Exception {
        return userMapper.getUserById(id);
    }

    @Override
    @Transactional
    public void registerUser(UserDto user) throws Exception {
        user.setPassword(hashing(user.getPassword()));
        userMapper.registerUser(user);
    }

    @Override
    @Transactional
    public void updateUser(UserDto user) throws Exception {
        user.setNewPassword(hashing(user.getNewPassword()));
        userMapper.updateUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(String id) throws Exception {
        userMapper.deleteUser(id);
    }

    @Override
    public UserDto loginUser(String id, String password) {
        Map<String, String> userMap = new HashMap<>();
        userMap.put("id", id);
        password = hashing(password);
        userMap.put("password", password);
        return userMapper.loginUser(userMap);
    }

    @Override
    public String findId(String name, String phone) {
        Map<String, String> userMap = new HashMap<>();
        userMap.put("name", name);
        userMap.put("phone", phone);
        return userMapper.checkID(userMap);
    }

    @Override
    public boolean checkPassword(String id, String name) {
        Map<String, String> userMap = new HashMap<>();
        userMap.put("name", name);
        userMap.put("id", id);
        return (userMapper.checkPW(userMap)==1)?true:false;
    }


    @Override
    public void changePW(UserDto userDto) {
        userDto.setNewPassword(hashing(userDto.getNewPassword()));
        userMapper.newPassword(userDto);
    }

    public String hashing(String word) {
        byte[] b = word.getBytes();
        String newWord = byteArrayToString(Encrypt.hash(b));
        return newWord;
    }

    public static String byteArrayToString(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte data : bytes) {
            builder.append(String.format("%x", data));
        }
        String string = builder.toString();
        String string2 = string.substring(40);
        return string2;
    }


}
