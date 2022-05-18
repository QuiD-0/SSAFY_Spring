package com.qna.service;

import com.qna.domain.Qna;

import java.util.List;

public interface QnaService {
    List<Qna> findAll();

    Qna findOne(int id);

    List<Qna> searchByWord(String word);

    void update(Qna qna);

    void insert(Qna qna);

    void delete(int id);

}
