package com.qna.service;

import com.qna.domain.Qna;
import com.qna.mapper.QnaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QnaServiceImpl implements QnaService{

    @Autowired
    private QnaMapper qnaMapper;

    @Override
    public List<Qna> findAll() {
        return qnaMapper.selectAll();
    }

    @Override
    public Qna findOne(int id) {
        return qnaMapper.selectOne(id);
    }

    @Override
    public List<Qna> searchByWord(String word) {
        return qnaMapper.findQnaByWord(word);
    }

    @Override
    public void update(Qna qna) {
        qnaMapper.update(qna);
    }

    @Override
    public void insert(Qna qna) {
        qnaMapper.insert(qna);
    }

    @Override
    public void delete(int id) {
        qnaMapper.delete(id);
    }
}
