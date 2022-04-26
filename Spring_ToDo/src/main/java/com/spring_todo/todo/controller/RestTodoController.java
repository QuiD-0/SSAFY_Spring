package com.spring_todo.todo.controller;

import com.spring_todo.todo.domain.Todo;
import com.spring_todo.todo.service.TodoService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class RestTodoController {

    @Autowired
    TodoService todoService;

    @GetMapping
    public List<Todo> all() {
        return todoService.FindAll();
    }

    @GetMapping("/{pk}")
    public Todo read(@PathVariable(name = "pk") String num) {
        return todoService.findOneByNum(num);
    }

    @DeleteMapping("/{pk}")
    public void del(@PathVariable(name = "pk") String num) {
        todoService.remove(num);
    }

    @DeleteMapping
    public void delAll() {
        todoService.removeAll();
    }

    @PostMapping
    public void write(@RequestBody Todo todo) {
        todoService.write(todo);
    }

    @PutMapping("/{pk}")
    public void writeProc(@PathVariable(name = "pk") String num) {
        todoService.done(num);
    }

    @GetMapping("/id/{pk}")
    public List<Todo> search(@PathVariable(name = "pk") String word) {
       return todoService.findById(word);
    }

}
