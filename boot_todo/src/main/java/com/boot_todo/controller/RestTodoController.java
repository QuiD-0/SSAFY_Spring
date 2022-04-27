package com.boot_todo.controller;

import com.boot_todo.domain.Todo;
import com.boot_todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
