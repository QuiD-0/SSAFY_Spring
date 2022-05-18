package com.qna;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.Qna.mapper"})
public class QnaApplication {

    public static void main(String[] args) {
        SpringApplication.run(QnaApplication.class, args);
    }

}
