package com.qna.service;

import com.qna.domain.QnaAnswer;
import com.qna.mapper.QnaAnswerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QnaAnswerServiceImpl implements QnaAnswerService {

    @Autowired
    private QnaAnswerMapper qnaAnswerMapper;


    @Override
    public List<QnaAnswer> findOne(int qna_id) {
        return qnaAnswerMapper.selectAnswers(qna_id);
    }

    @Override
    public void update(QnaAnswer qnaAnswer) {
        qnaAnswerMapper.updateAnswer(qnaAnswer);
    }

    @Override
    public void insert(QnaAnswer qnaAnswer) {
        qnaAnswerMapper.insertAnswer(qnaAnswer);
    }

    @Override
    public void delete(int answer_id) {
        qnaAnswerMapper.deleteAnswer(answer_id);
    }
}
