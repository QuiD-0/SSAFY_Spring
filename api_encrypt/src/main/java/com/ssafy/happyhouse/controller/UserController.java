package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.model.UserDto;
import com.ssafy.happyhouse.model.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.message.AuthException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin("localhost:8080")
@Api(value = "User", tags = {"유저 정보 API"})
public class UserController {
	
	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@ApiOperation(value = "전체 유저 목록", response = List.class)
	@GetMapping("/")
	public ResponseEntity<?> allUsers() throws Exception {
		List<UserDto> userList = userService.getAllUsers();
		logger.debug("user : {}", userList);
		if(!userList.isEmpty()) {
			return new ResponseEntity<>(userList, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@ApiOperation(value = "해당 ID를 가진 유저 검색", response = UserDto.class)
	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") String id) throws Exception {
		UserDto user = userService.getUserById(id);
		if(user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@ApiOperation(value = "해당 ID를 가진 유저 정보 수정")
	@PutMapping("/")
	public ResponseEntity<?> updateUser(@RequestBody UserDto userDto) throws Exception {
		UserDto user = userService.getUserById(userDto.getId());
		if(user == null){
			JSONObject json = new JSONObject();
			json.put("message", "해당 ID의 유저가 존재하지 않습니다.");
			return new ResponseEntity<>(json.toString(), HttpStatus.BAD_REQUEST);
		} else {
			userService.updateUser(userDto);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

	@ApiOperation(value = "해당 ID를 가진 유저 삭제")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") String id) throws Exception {
		UserDto user = userService.getUserById(id);
		if(user == null){
			JSONObject json = new JSONObject();
			json.put("message", "해당 ID의 유저가 존재하지 않습니다.");
			return new ResponseEntity<>(json.toString(), HttpStatus.BAD_REQUEST);
		} else {
			userService.deleteUser(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
