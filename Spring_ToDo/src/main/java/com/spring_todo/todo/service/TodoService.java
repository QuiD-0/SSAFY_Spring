package com.spring_todo.todo.service;

import com.spring_todo.todo.domain.Todo;

import java.util.List;

public interface TodoService {

    List<com.spring_todo.todo.domain.Todo> FindAll();

    List<com.spring_todo.todo.domain.Todo> findById(String id);

    com.spring_todo.todo.domain.Todo findOneByNum(String num);

    void write(Todo todo);

    void remove(String num);

    void removeAll();

    void done(String num);


}
