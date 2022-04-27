package com.boot_todo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.boot_todo.mapper"})
public class BootTodoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootTodoApplication.class, args);
    }

}
