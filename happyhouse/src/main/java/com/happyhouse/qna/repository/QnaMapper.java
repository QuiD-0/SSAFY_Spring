package com.happyhouse.qna.repository;

import com.happyhouse.qna.domain.Qna;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface QnaMapper {

    List<Qna> selectAll();

    Qna selectOne(int id);

    List<Qna> findQnaByWord(String word);

    void update(Qna qna);

    void insert(Qna qna);

    void delete(int id);
}
