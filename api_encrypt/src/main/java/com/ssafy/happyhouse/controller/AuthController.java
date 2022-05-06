package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.model.UserDto;
import com.ssafy.happyhouse.model.UserLoginDto;
import com.ssafy.happyhouse.model.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/auth")
@CrossOrigin("localhost:8080")
@Api(value = "Auth", tags = {"유저 인증 관련 API"})
public class AuthController {

    private final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession httpSession;

    @ApiOperation(value = "유저 회원 가입", response = UserDto.class)
    @PostMapping("/")
    public ResponseEntity<?> signUp(@RequestBody UserDto userDto) throws Exception {
        UserDto user = userService.getUserById(userDto.getId());
        if (user != null) {
            JSONObject json = new JSONObject();
            json.put("message", "이미 존재하는 ID 입니다.");
            return new ResponseEntity<>(json.toString(), HttpStatus.BAD_REQUEST);
        } else {
            userService.registerUser(userDto);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @ApiOperation(value = "유저 로그인", response = UserDto.class)
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginDto loginDto) throws Exception {
        UserDto user = userService.loginUser(loginDto.getId(), loginDto.getPassword());
        if (user == null) {
            JSONObject json = new JSONObject();
            json.put("message", "해당 ID 혹은 비밀번호가 틀립니다.");
            return new ResponseEntity<>(json.toString(), HttpStatus.BAD_REQUEST);
        } else {
            httpSession.setAttribute("userinfo", user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
    }

    @ApiOperation(value = "유저 로그아웃")
    @PostMapping("/logout")
    public ResponseEntity<?> logout() throws Exception {
        httpSession.invalidate();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
