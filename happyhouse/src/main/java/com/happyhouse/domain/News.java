package com.happyhouse.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class News {
    private String URL;
    private String title;
    private String publisher;
    private String date;

    @Override
    public String toString() {
        return "News{" +
                "URL='" + URL + '\'' +
                ", title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

}
