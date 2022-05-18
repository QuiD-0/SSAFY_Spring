package com.qna.mapper;

import com.qna.domain.Qna;
import com.qna.domain.QnaAnswer;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface QnaAnswerMapper {


    List<QnaAnswer> selectAnswers(int qna_id);

    void updateAnswer(QnaAnswer qnaAnswer);

    void insertAnswer(QnaAnswer qnaAnswer);

    void deleteAnswer(int answer_id);
}
