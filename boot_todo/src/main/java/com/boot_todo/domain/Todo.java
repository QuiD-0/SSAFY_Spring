package com.boot_todo.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Todo {
    String num, content, id, sdate, edate, done;

    public Todo(String num, String content, String id, String sdate, String edate, String done) {
        this.num = num;
        this.content = content;
        this.id = id;
        this.sdate = sdate;
        this.edate = edate;
        this.done = done;
    }
    @Override
    public String toString() {
        return "Todo{" +
                "num='" + num + '\'' +
                ", content='" + content + '\'' +
                ", id='" + id + '\'' +
                ", sdate='" + sdate + '\'' +
                ", edate='" + edate + '\'' +
                ", done='" + done + '\'' +
                '}';
    }
}
