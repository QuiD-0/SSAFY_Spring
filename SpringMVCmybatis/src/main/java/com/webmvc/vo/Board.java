package com.webmvc.vo;

//vo(value object):값을 저장하기 위한 용도.테이블 안의 레코드 한 건의 값을 저장하기 위한 목적
public class Board {
	private String num;
	private String pass;
	private String name;
	private String wdate;
	private String title;
	private String content;
	private String count;
	
	//constructor
	public Board() {}	
	
	public Board(String num, String pass, String name, String wdate, String title, String content, String count) {	
		this.num = num;
		this.pass = pass;
		this.name = name;
		this.wdate = wdate;
		this.title = title;
		this.content = content;
		this.count = count;
	}

	@Override
	public String toString() {
		return "Board{" +
				"num='" + num + '\'' +
				", pass='" + pass + '\'' +
				", name='" + name + '\'' +
				", wdate='" + wdate + '\'' +
				", title='" + title + '\'' +
				", content='" + content + '\'' +
				", count='" + count + '\'' +
				'}';
	}

	//getter/setter
	public String getNum() {
		return num;
	}
	
	public void setNum(String num) {
		this.num = num;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
}
