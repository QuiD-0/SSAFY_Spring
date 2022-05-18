package com.qna.controller;

import com.qna.domain.QnaAnswer;
import com.qna.service.QnaAnswerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "QnaAnswerController")
@RequestMapping("/answer")
@CrossOrigin("*")
public class QnaAnswerController {

    @Autowired
    QnaAnswerService qnaAnswerService;

    @GetMapping("/{pk}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<QnaAnswer>> getAnswers(@PathVariable(name = "pk") int qna_id) {
        List<QnaAnswer> answer = qnaAnswerService.findOne(qna_id);
        if (answer.isEmpty()){
            return new ResponseEntity<List<QnaAnswer>>(answer,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<QnaAnswer>>(answer,HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void write(@RequestBody QnaAnswer qnaAnswer) {
        qnaAnswerService.insert(qnaAnswer);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody QnaAnswer qnaAnswer) {
        qnaAnswerService.update(qnaAnswer);
    }

    @DeleteMapping("/{pk}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable(name = "pk") int answer_id) {
        qnaAnswerService.delete(answer_id);
    }

}
