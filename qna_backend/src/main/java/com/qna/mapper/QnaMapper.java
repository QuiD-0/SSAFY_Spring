package com.qna.mapper;

import com.qna.domain.Qna;
import org.mapstruct.Mapper;
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
