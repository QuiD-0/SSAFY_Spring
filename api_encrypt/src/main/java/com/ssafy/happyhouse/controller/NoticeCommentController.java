package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.model.NoticeCommentDto;
import com.ssafy.happyhouse.model.NoticeDto;
import com.ssafy.happyhouse.model.UserDto;
import com.ssafy.happyhouse.model.service.NoticeCommentService;
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
import java.util.List;

@RestController
@RequestMapping("/comment")
@CrossOrigin("localhost:8080")
@Api(value = "NoticeComment", tags = {"공지사항 댓글 API"})
public class NoticeCommentController {
	
	private final Logger logger = LoggerFactory.getLogger(NoticeCommentController.class);

	@Autowired
	private NoticeCommentService commentService;

	@Autowired
	private HttpSession httpSession;

	@ApiOperation(value = "공지사항의 댓글 목록", response = List.class)
	@GetMapping("/notice/{noticeId}")
	public ResponseEntity<?> getCommentByNoticeId(@PathVariable("noticeId") int noticeId) throws Exception {
		List<NoticeCommentDto> commentList = commentService.getCommentsByNoticeId(noticeId);
		logger.debug("notice : {}", commentList);
		if(!commentList.isEmpty()) {
			return new ResponseEntity<>(commentList, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@ApiOperation(value = "댓글 작성", response = NoticeDto.class)
	@PostMapping("/")
	public ResponseEntity<?> registerComment(@RequestBody NoticeCommentDto comment) throws Exception {
		UserDto user = (UserDto) httpSession.getAttribute("userinfo");
		comment.setUserId(user.getId());
		commentService.registerComment(comment);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value = "해당 ID를 가진 댓글 수정")
	@PutMapping("/")
	public ResponseEntity<?> updateComment(@RequestBody NoticeCommentDto comment) throws Exception {
		NoticeCommentDto c = commentService.getCommentById(comment.getCommentId());
		if(c == null){
			JSONObject json = new JSONObject();
			json.put("message", "해당 ID의 댓글이 존재하지 않습니다.");
			return new ResponseEntity<>(json.toString(), HttpStatus.BAD_REQUEST);
		} else {
			commentService.updateComment(comment);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

	@ApiOperation(value = "해당 ID를 가진 댓글 삭제")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteComment(@PathVariable("id") int id) throws Exception {
		NoticeCommentDto comment = commentService.getCommentById(id);
		if(comment == null){
			JSONObject json = new JSONObject();
			json.put("message", "해당 ID의 댓글이 존재하지 않습니다.");
			return new ResponseEntity<>(json.toString(), HttpStatus.BAD_REQUEST);
		} else {
			commentService.deleteCommentById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
