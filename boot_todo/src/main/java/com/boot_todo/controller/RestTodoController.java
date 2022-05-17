package com.boot_todo.controller;

import com.boot_todo.domain.Todo;
import com.boot_todo.service.TodoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "ToDoController")
@RequestMapping("/todo")
public class RestTodoController {

    private static final Logger LOGGER = LogManager.getLogger(RestTodoController.class);

    @Autowired
    TodoService todoService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    @ApiOperation(value = "모든 todo를 보여줍니다.", notes = "모든 todo를 json형태로 리턴")
    public List<Todo> all() {
        LOGGER.debug("hello log4j");
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
    @ResponseStatus(HttpStatus.CREATED)
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
