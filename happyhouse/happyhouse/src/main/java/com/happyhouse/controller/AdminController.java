package com.happyhouse.controller;

import com.happyhouse.domain.UserDto;
import com.happyhouse.service.AdminService;
import com.happyhouse.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
@Api(value = "Admin", tags = {"어드민 정보 API"})
public class AdminController {

    @Autowired
    private AdminService adminService;

    @ApiOperation(value = "전체 어드민 목록", response = List.class)
    @GetMapping
    public ResponseEntity<?> allAdmins() throws Exception {
        List<UserDto> userList = adminService.getAllAdmin();
        if (!userList.isEmpty()) {
            return new ResponseEntity<>(userList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @ApiOperation(value = "해당 ID를 가진 어드민 검색", response = UserDto.class)
    @GetMapping("/{id}")
    public ResponseEntity<?> getAdminById(@PathVariable("id") String id) throws Exception {
        UserDto user = adminService.getAdminById(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @ApiOperation(value = "해당 ID를 가진 어드민 정보 수정")
    @PutMapping
    public ResponseEntity<?> updateAdmin(@RequestBody UserDto userDto) throws Exception {
        UserDto user = adminService.getAdminById(userDto.getId());
        if (user == null) {
            JSONObject json = new JSONObject();
            json.put("message", "해당 ID의 어드민 존재하지 않습니다.");
            return new ResponseEntity<>(json.toString(), HttpStatus.BAD_REQUEST);
        } else {
            adminService.updateAdmin(userDto);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @ApiOperation(value = "해당 ID를 가진 어드민 삭제")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAdmin(@PathVariable("id") String id) throws Exception {
        UserDto user = adminService.getAdminById(id);
        if (user == null) {
            JSONObject json = new JSONObject();
            json.put("message", "해당 ID의 어드민이 존재하지 않습니다.");
            return new ResponseEntity<>(json.toString(), HttpStatus.BAD_REQUEST);
        } else {
            adminService.deleteAdmin(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @ApiOperation(value = "어드민 등록", response = UserDto.class)
    @PostMapping
    public ResponseEntity<?> signUpAdmin(@RequestBody UserDto userDto) throws Exception {
        UserDto user = adminService.getAdminById(userDto.getId());
        if (user != null) {
            JSONObject json = new JSONObject();
            json.put("message", "이미 등록된 어드민 입니다.");
            return new ResponseEntity<>(json.toString(), HttpStatus.BAD_REQUEST);
        } else {
            adminService.registerAdmin(userDto);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
