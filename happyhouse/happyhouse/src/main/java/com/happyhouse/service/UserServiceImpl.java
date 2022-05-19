package com.happyhouse.service;

import com.happyhouse.domain.UserDto;
import com.happyhouse.repository.UserMapper;
import com.happyhouse.util.Encrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void registerUser(UserDto user) throws Exception {
        user.setPassword(hashing(user.getPassword()));
        userMapper.registerUser(user);
    }

    @Override
    public void updateUser(UserDto user) throws Exception {
        userMapper.updateUser(user);
    }

    @Override
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
