package com.webmvc.service;

import com.webmvc.vo.Board;

import java.util.ArrayList;

//Controller를 위한 인터페이스
public interface BoardService {
    public ArrayList<Board> selectAll();//모든 글정보

    public Board selectOne(String num);//해당 번호의 글 하나

    public void insert(Board b);//새글 등록

    public void delete(String num);//글 삭제
}
