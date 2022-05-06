package com.ssafy.happyhouse.model.service;

import com.ssafy.happyhouse.model.NoticeCommentDto;

import java.util.List;

public interface NoticeCommentService {
	List<NoticeCommentDto> getCommentsByNoticeId(int noticeId);
	NoticeCommentDto getCommentById(int id);
	void registerComment(NoticeCommentDto comment);
	void updateComment(NoticeCommentDto comment);
	void deleteCommentById(int id);
}
