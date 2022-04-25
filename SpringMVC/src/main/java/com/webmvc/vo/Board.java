package com.webmvc.vo;

import lombok.*;

@Getter
@Setter
//@NoArgsConstructor   // final이 있을때는 사용못함
@AllArgsConstructor
@RequiredArgsConstructor // final, @NonNull이 붙어있는 필드를 arg로 하는 생성자를 생성해준다.
@EqualsAndHashCode(of = {"num","name"}, callSuper = false) // num,name 만 같으면 같은 객체라고 리턴
@Data
public class Board {
    @NonNull
    private String num;
    @NonNull
    private String pass;
    private final String name;
    private String wdate;
    private String title;
    private String content;
    private String count;

    public static void main(String[] args) {
        Board b1 = new Board("111","111","tommy","2020-04-25","hi","hello world!","0");
        Board b2 = new Board("111","222","tommy","2020-04-26","hello","hi world!","1");
        Board b3 = new Board("111","222","tommyCar","2020-04-26","hello","hi world!","1");
        System.out.println(b1.equals(b2));
        System.out.println(b1.equals(b3));
    }

}
