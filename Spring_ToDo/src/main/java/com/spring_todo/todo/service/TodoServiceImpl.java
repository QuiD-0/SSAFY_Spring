package com.spring_todo.todo.service;

import com.spring_todo.todo.domain.Todo;
import com.spring_todo.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    @Autowired
    TodoRepository todoRepository;

    @Override
    public List<com.spring_todo.todo.domain.Todo> FindAll() {
        return todoRepository.selectAll();
    }

    @Override
    public List<Todo> findById(String id) {
        return todoRepository.selectsById(id);
    }

    @Override
    public Todo findOneByNum(String num) {
        return todoRepository.selectOne(num);
    }


    @Override
    public void write(Todo todo) {
        todoRepository.insert(todo);
    }

    @Override
    public void remove(String num) {
        todoRepository.delete(num);
    }

    @Override
    public void removeAll() {
        todoRepository.deleteAll();
    }

    @Override
    public void done(String num) {
        todoRepository.done(num);
    }
}
