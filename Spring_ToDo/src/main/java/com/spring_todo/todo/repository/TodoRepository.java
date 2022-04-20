package com.spring_todo.todo.repository;

import com.spring_todo.todo.domain.Todo;

import java.util.List;

public interface TodoRepository {
    List<Todo> selectAll();

    List<Todo> selectsById(String id);

    Todo selectOne(String num);

    void insert(Todo todo);

    void delete(String num);

    void deleteAll();

    void done(String num);
}
