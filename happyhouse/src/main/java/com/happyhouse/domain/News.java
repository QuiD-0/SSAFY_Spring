package com.happyhouse.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class News {
    private String URL;
    private String title;
    private String description;
    private String publisher;
    private String date;

}
