package com.ssafy.happyhouse.model.mapper;

import com.ssafy.happyhouse.model.NoticeDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {
	List<NoticeDto> getNotice(int start);
	String getNoticeMaxPage();
	NoticeDto getNoticeById(int id);
	void registerNotice(NoticeDto notice);
	void updateNotice(NoticeDto notice);
	void increaseViewCount(int id);
	void deleteNoticeById(int id);
	List<NoticeDto> getAllName();
	List<NoticeDto> getNoticeByIdList(List<Integer> list);
}
