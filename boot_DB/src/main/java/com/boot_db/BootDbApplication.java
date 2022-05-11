package com.boot_db;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@MapperScan(basePackages = {"com.boot_db.mapper"})
@SpringBootApplication
@CrossOrigin("*")
public class BootDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootDbApplication.class, args);
    }

}
