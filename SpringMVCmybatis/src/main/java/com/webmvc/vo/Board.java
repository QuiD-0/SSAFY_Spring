package com.webmvc.vo;

import lombok.Getter;
import lombok.Setter;

//vo(value object):값을 저장하기 위한 용도.테이블 안의 레코드 한 건의 값을 저장하기 위한 목적
@Getter
@Setter
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

}
