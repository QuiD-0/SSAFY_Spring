package com.webmvc.controller;

import com.webmvc.service.BoardService;
import com.webmvc.vo.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

//FrontController에게서 요청을 넘겨 받아 Service한테 작업을 넘김
//@Controller
@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;// interface type

    // request < session < application
    @GetMapping
    public ResponseEntity<List<Board>> list() {
        ArrayList<Board> list = boardService.selectAll();
        return new ResponseEntity<List<Board>>(list, HttpStatus.OK);
    }

    @GetMapping("/{pk}")
    public ResponseEntity<Board> read(@PathVariable(name = "pk") String num) {
        Board b = boardService.selectOne(num);
        return new ResponseEntity(b,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity insertProcess(@RequestBody Board board) {
        boardService.insert(board);
        return new ResponseEntity(HttpStatus.OK);

    }

    @DeleteMapping
    public ResponseEntity delete(String num) {
        boardService.delete(num);
        return new ResponseEntity(HttpStatus.OK);
    }


    @GetMapping("/search/{condition}/{pk}")
    public ResponseEntity<List<Board>> search(@PathVariable(name = "pk") String word, @PathVariable(name = "condition") String condition) {
        ArrayList<Board> list = boardService.search(word, condition);// data 받음
        return new ResponseEntity<List<Board>>(list,HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody Board board) {
        boardService.update(board);
        return new ResponseEntity(HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView ExceptionHandler(Exception e){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorMsg",e.getMessage());
        modelAndView.setViewName("errorPage");
        return modelAndView;
    }

}
