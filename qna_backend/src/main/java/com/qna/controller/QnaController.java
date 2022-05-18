package com.qna.controller;

import com.qna.domain.Qna;
import com.qna.service.QnaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "QnaController")
@RequestMapping("/qna")
@CrossOrigin("*")
public class QnaController {

    @Autowired
    QnaService qnaService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "모든 QNA 조회")
    public List<Qna> all() {
        return qnaService.findAll();
    }

    @GetMapping("/{pk}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "qna_id 값을 통한 조회")
    public Qna getOne(@PathVariable(name = "pk") int id) {
        return qnaService.findOne(id);
    }

    @GetMapping("/search/{word}")
    @ApiOperation(value = "title값을 통한 QNA 조회")
    public ResponseEntity<List<Qna>> search(@PathVariable(name = "word") String word) {
        List<Qna> res = qnaService.searchByWord(word);
        if (res.isEmpty()) {
            return new ResponseEntity<>(res, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "QNA 작성", notes = "name, title, content만 넣어주면 됩니다")
    public void write(@RequestBody Qna qna) {
        qnaService.insert(qna);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "QNA 수정", notes = "qna_id, title, content만 넣어주면 됩니다")
    public void update(@RequestBody Qna qna) {
        qnaService.update(qna);
    }

    @DeleteMapping("/{pk}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "qna_id값에 해당하는 QNA 삭제")
    public void delete(@PathVariable(name = "pk") int id) {
        qnaService.delete(id);
    }

}
