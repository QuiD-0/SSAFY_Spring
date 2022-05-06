package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.model.GetNoticeResponseDto;
import com.ssafy.happyhouse.model.NoticeDto;
import com.ssafy.happyhouse.model.UserDto;
import com.ssafy.happyhouse.model.service.NoticeService;
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

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/notice")
@CrossOrigin("localhost:8080")
@Api(value = "Notice", tags = {"공지사항 API"})
public class NoticeController {
	
	private final Logger logger = LoggerFactory.getLogger(NoticeController.class);

	@Autowired
	private NoticeService noticeService;

	@Autowired
	private HttpSession httpSession;

	@ApiOperation(value = "공지사항 목록(페이징)", response = List.class)
	@GetMapping("/all/{page}")
	public ResponseEntity<?> getNotice(@PathVariable("page") int page) throws Exception {
		GetNoticeResponseDto notice = noticeService.getNotice(page);
		logger.debug("notice : {}", notice);
		if(!notice.getNoticeList().isEmpty()) {
			return new ResponseEntity<>(notice, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@ApiOperation(value = "해당 ID를 가진 공지사항 검색", response = NoticeDto.class)
	@GetMapping("/detail/{id}")
	public ResponseEntity<?> getNoticeById(@PathVariable("id") int id) throws Exception {
		NoticeDto notice = noticeService.getNoticeById(id);
		if(notice != null) {
			noticeService.increaseViewCount(id);
			return new ResponseEntity<>(notice, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@ApiOperation(value = "공지사항 작성", response = NoticeDto.class)
	@PostMapping("/")
	public ResponseEntity<?> registerNotice(@RequestBody NoticeDto noticeDto) throws Exception {
		UserDto user = (UserDto) httpSession.getAttribute("userinfo");
		noticeDto.setUserId(user.getId());
		noticeService.registerNotice(noticeDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value = "해당 ID를 가진 공지사항 수정")
	@PutMapping("/")
	public ResponseEntity<?> updateNotice(@RequestBody NoticeDto noticeDto) throws Exception {
		NoticeDto notice = noticeService.getNoticeById(noticeDto.getNoticeId());
		if(notice == null){
			JSONObject json = new JSONObject();
			json.put("message", "해당 ID의 공지사항이 존재하지 않습니다.");
			return new ResponseEntity<>(json.toString(), HttpStatus.BAD_REQUEST);
		} else {
			noticeService.updateNotice(noticeDto);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

	@ApiOperation(value = "해당 ID를 가진 공지사항 삭제")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteNotice(@PathVariable("id") int id) throws Exception {
		NoticeDto notice = noticeService.getNoticeById(id);
		if(notice == null){
			JSONObject json = new JSONObject();
			json.put("message", "해당 ID의 공지사항이 존재하지 않습니다.");
			return new ResponseEntity<>(json.toString(), HttpStatus.BAD_REQUEST);
		} else {
			noticeService.deleteNoticeById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
