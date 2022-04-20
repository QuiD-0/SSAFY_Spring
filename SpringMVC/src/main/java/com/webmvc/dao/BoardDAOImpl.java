package com.webmvc.dao;

import com.webmvc.util.DBUtil;
import com.webmvc.vo.Board;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

//BoardDAO의 메소드를 구현한 객체.
//Service에서 들어온 요청을 최종적으로 처리하는 객체
//DB 작업 수행(CRUD)
//@Repository: 컨테이너가 생성하는 객체 중에 db 작업하는 객체

@Repository
public class BoardDAOImpl implements BoardDAO {
    ArrayList<Board> list;// select 한 결과를 담아놓을 자료구조
    DBUtil util;

    public BoardDAOImpl() {// 만들어진 connection pool 찾아오기
        try {
            util = DBUtil.getInstance();
            list = new ArrayList<>();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Board> selectAll() {
        try {
            list.clear();

            Connection con = util.getConnection();
            Statement stat = con.createStatement();
            String q = "select num, name, wdate, title, count from board order by num desc";
            ResultSet rs = stat.executeQuery(q);

            while (rs.next()) {
                String num = rs.getString(1);
                String name = rs.getString(2);
                String wdate = rs.getString(3);
                String title = rs.getString(4);
                String count = rs.getString(5);

                Board b = new Board(num, null, name, wdate, title, null, count);
                list.add(b);
            }
            con.close();// pool에 반납
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;// ->service로 감
    }

    @Override
    public Board selectOne(String num) {
        Board b = null;
        try {

            String q = "select * from board where num = ?";
            Connection con = util.getConnection();
            ;// pool에서 한개 빌려옴
            PreparedStatement stat = con.prepareStatement(q);
            stat.setString(1, num);// ?에 setting

            ResultSet rs = stat.executeQuery();// 실행
            rs.next();

            String name = rs.getString(3);
            String wdate = rs.getString(4);
            String title = rs.getString(5);
            String content = rs.getString(6);
            String count = rs.getString(7);

            b = new Board(num, null, name, wdate, title, content, count);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

    @Override
    public void insert(Board b) {
        try {
            Connection con = util.getConnection();
            String q = "insert into BOARD(PASS,NAME,WDATE,TITLE,CONTENT,COUNT) values(?,?,sysdate(),?,?,0)";

            PreparedStatement stat = con.prepareStatement(q);
            stat.setString(1, b.getPass());
            stat.setString(2, b.getName());
            stat.setString(3, b.getTitle());
            stat.setString(4, b.getContent());

            stat.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String num) {
        try {
            String q = "delete from board where num = ?";
            Connection con = util.getConnection();// pool에서 한개 빌려옴
            PreparedStatement stat = con.prepareStatement(q);
            stat.setString(1, num);// ?에 setting

            stat.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void countUp(String num) {
        try {

            String q = "update board set count = count + 1 where num = ?";
            Connection con = util.getConnection();// pool에서 한개 빌려옴
            PreparedStatement stat = con.prepareStatement(q);
            stat.setString(1, num);// ?에 setting

            stat.executeUpdate();// 실행
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Board> search(String word,String type) {
        try {
            list.clear();

            Connection con = util.getConnection();
            Statement stat = con.createStatement();
            String q = "select num, name, wdate, title, count from board where "+type+" like '%"+word+"%' order by num desc";
            ResultSet rs = stat.executeQuery(q);
            System.out.println(q);
            while (rs.next()) {
                String num = rs.getString(1);
                String name = rs.getString(2);
                String wdate = rs.getString(3);
                String title = rs.getString(4);
                String count = rs.getString(5);
                Board b = new Board(num, null, name, wdate, title, null, count);
                list.add(b);
            }
            con.close();// pool에 반납
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;// ->service로 감
    }

}
