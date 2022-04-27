package com.boot_todo.service;



import com.boot_todo.domain.Todo;

import java.util.List;

public interface TodoService {

    List<Todo> FindAll();

    List<Todo> findById(String id);

    Todo findOneByNum(String num);

    void write(Todo todo);

    void remove(String num);

    void removeAll();

    void done(String num);


}
