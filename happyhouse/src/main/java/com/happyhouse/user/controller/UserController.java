package com.happyhouse.user.controller;

import com.happyhouse.user.domain.UserDto;
import com.happyhouse.user.domain.UserLoginDto;
import com.happyhouse.user.service.AdminService;
import com.happyhouse.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
@Api(value = "User", tags = {"유저 정보 API"})
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private HttpSession httpSession;

    @ApiOperation(value = "전체 유저 목록", response = List.class)
    @GetMapping
    public ResponseEntity<?> allUsers() throws Exception {
        List<UserDto> userList = userService.getAllUsers();
        if (!userList.isEmpty()) {
            return new ResponseEntity<>(userList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @ApiOperation(value = "해당 ID를 가진 유저 검색", response = UserDto.class)
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") String id) throws Exception {
        UserDto user = userService.getUserById(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @ApiOperation(value = "해당 ID를 가진 유저 정보 수정")
    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody UserDto userDto) throws Exception {
        UserDto user = userService.getUserById(userDto.getId());
        JSONObject json = new JSONObject();
        if (user == null) {
            json.put("message", "해당 ID의 유저가 존재하지 않습니다.");
            return new ResponseEntity<>(json.toString(), HttpStatus.BAD_REQUEST);
        }
        UserDto checkedUser = userService.loginUser(userDto.getId(), userDto.getPassword());
        if (checkedUser == null) {
            json.put("message", "잘못된 비밀번호 입니다.");
            return new ResponseEntity<>(json.toString(), HttpStatus.BAD_REQUEST);
        }
        if (userDto.getNewPassword() == null) {
            userDto.setNewPassword(userDto.getPassword());
        }
        userService.updateUser(userDto);
        if (user.getAdmin().equals("Y")) {
            adminService.updateAdmin(userDto);
        }
        json.put("message", "회원 정보 수정 성공");
        return new ResponseEntity<>(json.toString(), HttpStatus.OK);
    }

    @ApiOperation(value = "해당 ID를 가진 유저 삭제")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") String id) throws Exception {
        UserDto user = userService.getUserById(id);
        if (user == null) {
            JSONObject json = new JSONObject();
            json.put("message", "해당 ID의 유저가 존재하지 않습니다.");
            return new ResponseEntity<>(json.toString(), HttpStatus.BAD_REQUEST);
        } else {
            userService.deleteUser(id);
            if (user.getAdmin().equals("Y")) {
                adminService.deleteAdmin(user.getId());
            }
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @ApiOperation(value = "유저 회원 가입", response = UserDto.class)
    @PostMapping
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

    @ApiOperation(value = "ID찾기")
    @PostMapping("/findid")
    public ResponseEntity<?> findid(@RequestBody UserDto userDto) throws Exception {
        String id = userService.findId(userDto.getName(), userDto.getPhone());
        System.out.println(id);
        JSONObject json = new JSONObject();
        if (id == null) {
            json.put("message", "일치하는 ID가 없습니다.");
            return new ResponseEntity<>(json.toString(), HttpStatus.BAD_REQUEST);
        }
        json.put("id", id);
        return new ResponseEntity<>(json.toString(), HttpStatus.OK);
    }

    @ApiOperation(value = "PW찾기")
    @PostMapping("/findpw")
    public ResponseEntity<?> findpw(@RequestBody UserDto userDto) throws Exception {
        JSONObject json = new JSONObject();
        if (!userService.checkPassword(userDto.getId(), userDto.getName())) {
            json.put("message", "ID와 name이 일치하지 않습니다.");
            return new ResponseEntity<>(json.toString(), HttpStatus.BAD_REQUEST);
        }
        json.put("message", "인증 완료");
        return new ResponseEntity<>(json.toString(), HttpStatus.OK);
    }

    @ApiOperation(value = "PW재설정", notes = "id와 newPassword에 값을 담아주세요")
    @PutMapping("/findpw")
    public ResponseEntity<?> changePW(@RequestBody UserDto userDto) throws Exception {
        JSONObject json = new JSONObject();
        userService.changePW(userDto);
        json.put("message", "비밀번호 재설정 완료");
        return new ResponseEntity<>(json.toString(), HttpStatus.OK);
    }
}
