package com.qna.controller;

import com.qna.domain.Qna;
import com.qna.service.QnaService;
import io.swagger.annotations.Api;
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
    public List<Qna> all() {
        return qnaService.findAll();
    }

    @GetMapping("/{pk}")
    @ResponseStatus(HttpStatus.OK)
    public Qna getOne(@PathVariable(name = "pk") int id) {
        return qnaService.findOne(id);
    }

    @GetMapping("/search/{word}")
    public ResponseEntity<List<Qna>> search(@PathVariable(name = "word") String word) {
        List<Qna> res = qnaService.searchByWord(word);
        if (res.isEmpty()) {
            return new ResponseEntity<>(res, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void write(@RequestBody Qna qna) {
        qnaService.insert(qna);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody Qna qna) {
        qnaService.update(qna);
    }

    @DeleteMapping("/{pk}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable(name = "pk") int id) {
        qnaService.delete(id);
    }

}
