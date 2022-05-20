package com.happyhouse.service;


import com.happyhouse.domain.QnaAnswer;

import java.util.List;

public interface QnaAnswerService {

    List<QnaAnswer> findOne(int qna_id);

    void update(QnaAnswer QnaAnswer);

    void insert(QnaAnswer QnaAnswer);

    void delete(int id);

}
