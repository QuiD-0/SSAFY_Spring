package com.spring_todo.todo.mapper;

import com.spring_todo.todo.domain.Todo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoMapper {
    List<Todo> selectAll();

    List<Todo> selectsById(String id);

    Todo selectOne(String num);

    void insert(Todo todo);

    void delete(String num);

    void deleteAll();

    void done(String num);
}
