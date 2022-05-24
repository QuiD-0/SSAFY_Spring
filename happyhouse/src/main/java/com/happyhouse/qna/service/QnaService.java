package com.happyhouse.qna.service;


import com.happyhouse.qna.domain.Qna;

import java.util.List;

public interface QnaService {
    List<Qna> findAll();

    Qna findOne(int id);

    List<Qna> searchByWord(String word);

    void update(Qna qna);

    void insert(Qna qna);

    void delete(int id);

}
