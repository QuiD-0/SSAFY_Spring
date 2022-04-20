package com.spring_todo.todo.domain;

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

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSdate() {
        return sdate;
    }

    public void setSdate(String sdate) {
        this.sdate = sdate;
    }

    public String getEdate() {
        return edate;
    }

    public void setEdate(String edate) {
        this.edate = edate;
    }

    public String getDone() {
        return done;
    }

    public void setDone(String done) {
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
