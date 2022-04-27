package com.boot_todo.controller;

import com.boot_todo.domain.Todo;
import com.boot_todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.List;

//@Controller
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping("/list")
    public String all(Model model) {
        List<Todo> list = todoService.FindAll();
        model.addAttribute("list", list);
        return "list";
    }

    @GetMapping("/read")
    public String read(String num,Model model){
        Todo todo = todoService.findOneByNum(num);
        model.addAttribute("b",todo);
        return "read";
    }
    @GetMapping("/delete")
    public String del(String num){
        todoService.remove(num);
        return "redirect:list";
    }
    @GetMapping("/deleteAll")
    public String delAll(){
        todoService.removeAll();
        return "redirect:list";
    }
    @GetMapping("/write")
    public String write(){
        return "writeForm";
    }
    @PostMapping("/writeP")
    public String writeProc(Todo todo){
        todoService.write(todo);
        return "redirect:list";
    }
    @GetMapping("/done")
    public String writeProc(String num){
        todoService.done(num);
        return "redirect:list";
    }
    @GetMapping("/search")
    public String search(String condition,String word,Model model){
        List<Todo> list = null;
        if(condition.equals("id")){
             list = todoService.findById(word);
        }else{
            list= Collections.singletonList(todoService.findOneByNum(word));
        }
        model.addAttribute("list",list);
        return "list";
    }

}
