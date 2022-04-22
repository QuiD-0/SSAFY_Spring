package com.webmvc.service;

import com.webmvc.mapper.BoardMapper;
import com.webmvc.vo.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;


@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardMapper mapper;

    @Override
    public ArrayList<Board> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public Board selectOne(String num) {
        mapper.countUp(num);
        Board b = mapper.selectOne(num);
        return b;//Controller한테 리턴됨
    }

    @Override
    @Transactional
    public void insert(Board b) {
        mapper.insert(b);
    }

    @Override
    @Transactional
    public void delete(String num) {
        mapper.delete(num);
    }

    @Override
    public ArrayList<Board> search(String word, String condition) {
        HashMap map = new HashMap();
        map.put("word", word);
        map.put("condition", condition);
        return mapper.search(map);
    }

    @Override
    public void update(Board board) {
        mapper.update(board);
    }

    @Override
    @Transactional
    public void test() {
        mapper.test();
        mapper.test();
    }

    @Override
    public int checkPW(String id, String pw) {
        HashMap map = new HashMap();
        map.put("id",id);
        map.put("pw",pw);
        return mapper.checkPass(map);
    }

}
