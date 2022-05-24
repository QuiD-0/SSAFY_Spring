package com.happyhouse.qna.controller;

import com.happyhouse.qna.domain.QnaAnswer;
import com.happyhouse.qna.service.QnaAnswerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "QnaAnswerController", tags = {"답변 API"})
@RequestMapping("/answer")
@CrossOrigin("*")
public class QnaAnswerController {

    @Autowired
    QnaAnswerService qnaAnswerService;

    @GetMapping("/{pk}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "qna_id 값에 해당하는 모든 QNA_Answer 보기", notes = "한개의 질문글의 모든 답변을 나타냅니다.")
    public ResponseEntity<List<QnaAnswer>> getAnswers(@PathVariable(name = "pk") int qna_id) {
        List<QnaAnswer> answer = qnaAnswerService.findOne(qna_id);
        if (answer.isEmpty()){
            return new ResponseEntity<List<QnaAnswer>>(answer,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<QnaAnswer>>(answer,HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "QNA_Answer 작성", notes = "qna_id, name, title, content만 넣어주면 됩니다.")
    public void write(@RequestBody QnaAnswer qnaAnswer) {
        qnaAnswerService.insert(qnaAnswer);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "QNA_Answer 수정", notes = "answer_id, title, content만 넣어주면 됩니다.")
    public void update(@RequestBody QnaAnswer qnaAnswer) {
        qnaAnswerService.update(qnaAnswer);
    }

    @DeleteMapping("/{pk}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "QNA_Answer 삭제", notes = "answer_id 값에 해당하는 값 삭제")
    public void delete(@PathVariable(name = "pk") int answer_id) {
        qnaAnswerService.delete(answer_id);
    }

}
