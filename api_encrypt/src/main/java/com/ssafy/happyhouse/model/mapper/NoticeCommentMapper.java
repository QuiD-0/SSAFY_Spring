package com.ssafy.happyhouse.model.mapper;

import com.ssafy.happyhouse.model.NoticeCommentDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeCommentMapper {
	List<NoticeCommentDto> getCommentsByNoticeId(int noticeId);
	NoticeCommentDto getCommentById(int id);
	void registerComment(NoticeCommentDto comment);
	void updateComment(NoticeCommentDto comment);
	void deleteCommentById(int id);
}
