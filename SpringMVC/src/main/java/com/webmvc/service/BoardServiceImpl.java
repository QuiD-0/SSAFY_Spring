package com.webmvc.service;

import com.webmvc.dao.BoardDAO;
import com.webmvc.vo.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

//BoardService의 메소드를 구현한 객체.
//Controller에서 들어온 요청을 실제로 처리하는 객체
//DAO에게 요청사항을 전달함
@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardDAO dao;

    @Override
    public ArrayList<Board> selectAll() {
        return dao.selectAll();
    }

    @Override
    public Board selectOne(String num) {
        dao.countUp(num);
        Board b = dao.selectOne(num);
        return b;//Controller한테 리턴됨
    }

    @Override
    public void insert(Board b) {
        dao.insert(b);
    }

    @Override
    public void delete(String num) {
        dao.delete(num);
    }

}
