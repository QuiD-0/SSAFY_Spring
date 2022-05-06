package com.ssafy.happyhouse.model.service;

import com.ssafy.happyhouse.model.GetNoticeResponseDto;
import com.ssafy.happyhouse.model.NoticeDto;
import com.ssafy.happyhouse.model.mapper.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public GetNoticeResponseDto getNotice(int page) {
        int start = (page-1) * 10;
        GetNoticeResponseDto dto = new GetNoticeResponseDto();
        dto.setNoticeList(noticeMapper.getNotice(start));
        dto.setMaxPageNum(noticeMapper.getNoticeMaxPage());
        return dto;
    }

    @Override
    public NoticeDto getNoticeById(int id) {
        return noticeMapper.getNoticeById(id);
    }

    @Override
    public void registerNotice(NoticeDto notice) {
        noticeMapper.registerNotice(notice);
    }

    @Override
    public void updateNotice(NoticeDto notice) {
        noticeMapper.updateNotice(notice);
    }

    @Override
    public void increaseViewCount(int id) {
        noticeMapper.increaseViewCount(id);
    }

    @Override
    public void deleteNoticeById(int id) {
        noticeMapper.deleteNoticeById(id);
    }
}
