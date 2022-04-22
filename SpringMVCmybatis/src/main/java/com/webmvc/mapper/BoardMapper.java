package com.webmvc.mapper;

import com.webmvc.vo.Board;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

//Service를 위한 인터페이스

public interface BoardMapper {
    public ArrayList<Board> selectAll();//모든 글정보

    public Board selectOne(String num);//해당 번호의 글 하나

    public void insert(Board b);//새글 등록

    public void delete(String num);//글 삭제

    public void countUp(String num);//조회수 증가

    ArrayList<Board> search(String word, String type);
}
