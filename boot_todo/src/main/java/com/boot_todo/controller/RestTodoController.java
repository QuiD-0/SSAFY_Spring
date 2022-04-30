package com.boot_todo.controller;

import com.boot_todo.domain.Todo;
import com.boot_todo.mapper.TodoMapper;
import com.boot_todo.service.TodoService;
import com.boot_todo.service.TodoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "ToDoController")
@RequestMapping("/todo")
public class RestTodoController {

    @Autowired
    TodoService todoService;

    @GetMapping
    @ApiOperation(value = "모든 todo를 보여줍니다.", notes = "모든 todo를 json형태로 리턴")
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
    public void update(@PathVariable(name = "pk") String num) {
        todoService.done(num);
    }

    @GetMapping("/id/{pk}")
    public List<Todo> search(@PathVariable(name = "pk") String word) {
       return todoService.findById(word);
    }

}
