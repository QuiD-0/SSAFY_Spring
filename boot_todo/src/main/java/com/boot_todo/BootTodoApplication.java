package com.boot_todo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.boot_todo.mapper"})
public class BootTodoApplication {
    private static Logger logger = LogManager.getLogger(BootTodoApplication.class);
    public static void main(String[] args) {

        SpringApplication.run(BootTodoApplication.class, args);
    }

}
