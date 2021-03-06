package com.boot_todo.service;

import com.boot_todo.domain.Todo;
import com.boot_todo.mapper.TodoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {
    private final TodoMapper todoMapper;

    @Override
    public List<Todo> FindAll() {
        return todoMapper.selectAll();
    }

    @Override
    public List<Todo> findById(String id) {
        return todoMapper.selectsById(id);
    }

    @Override
    public Todo findOneByNum(String num) {
        return todoMapper.selectOne(num);
    }


    @Override
    public void write(Todo todo) {
        todoMapper.insert(todo);
    }

    @Override
    public void remove(String num) {
        todoMapper.delete(num);
    }

    @Override
    public void removeAll() {
        todoMapper.deleteAll();
    }

    @Override
    public void done(String num) {
        todoMapper.done(num);
    }

    @Override
    public List<Todo> findContent(String word) {
        return todoMapper.searchContent(word);
    }
}
