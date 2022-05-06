package com.ssafy.happyhouse.model.service;

import com.ssafy.happyhouse.model.NoticeCommentDto;
import com.ssafy.happyhouse.model.mapper.NoticeCommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeCommentServiceImpl implements NoticeCommentService {

    @Autowired
    private NoticeCommentMapper noticeCommentMapper;

    @Override
    public List<NoticeCommentDto> getCommentsByNoticeId(int noticeId) {
        return noticeCommentMapper.getCommentsByNoticeId(noticeId);
    }

    @Override
    public NoticeCommentDto getCommentById(int id) {
        return noticeCommentMapper.getCommentById(id);
    }

    @Override
    public void registerComment(NoticeCommentDto comment) {
        noticeCommentMapper.registerComment(comment);
    }

    @Override
    public void updateComment(NoticeCommentDto comment) {
        noticeCommentMapper.updateComment(comment);
    }

    @Override
    public void deleteCommentById(int id) {
        noticeCommentMapper.deleteCommentById(id);
    }
}
