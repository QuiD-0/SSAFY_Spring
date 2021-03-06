package com.ssafy.happyhouse.model.service;

import com.ssafy.happyhouse.model.GetNoticeResponseDto;
import com.ssafy.happyhouse.model.NoticeDto;

import java.util.List;

public interface NoticeService {
	GetNoticeResponseDto getNotice(int page);
	NoticeDto getNoticeById(int id);
	void registerNotice(NoticeDto notice);
	void updateNotice(NoticeDto notice);
	void increaseViewCount(int id);
	void deleteNoticeById(int id);
	List<NoticeDto> searchNoticeByKeywords(String keywords);
}
