package com.spring_todo.todo.repository;

import com.spring_todo.todo.domain.Todo;
import com.spring_todo.todo.util.DBUtil;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TodoRepositoryImpl implements TodoRepository {
    ArrayList<Todo> list;
    DBUtil util;

    public TodoRepositoryImpl() {
        try {
            util = DBUtil.getInstance();
            list = new ArrayList<>();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Todo> selectAll() {
        try {
            list.clear();

            Connection con = util.getConnection();
            Statement stat = con.createStatement();
            String q = "select * from todolist order by num asc";
            ResultSet rs = stat.executeQuery(q);

            while (rs.next()) {
                String num = rs.getString(1);
                String content = rs.getString(2);
                String id = rs.getString(3);
                String sdate = rs.getString(4);
                String edate = rs.getString(5);
                String done = rs.getString(6);
                Todo todo = new Todo(num, content, id, sdate, edate, done);
                list.add(todo);
            }
//            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Todo> selectsById(String word) {
        try {
            list.clear();
            Connection con = util.getConnection();
            Statement stat = con.createStatement();
            String q = "select * from todolist where id like '%" + word + "%' order by num asc";
            ResultSet rs = stat.executeQuery(q);

            while (rs.next()) {
                String num = rs.getString(1);
                String content = rs.getString(2);
                String id = rs.getString(3);
                String sdate = rs.getString(4);
                String edate = rs.getString(5);
                String done = rs.getString(6);
                Todo todo = new Todo(num, content, id, sdate, edate, done);
                list.add(todo);
            }
//            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Todo selectOne(String num) {
        Todo todo = null;
        try {
            Connection con = util.getConnection();
            Statement stat = con.createStatement();
            String q = "select * from todolist where num = " + num;
            ResultSet rs = stat.executeQuery(q);

            while (rs.next()) {
                String content = rs.getString(2);
                String id = rs.getString(3);
                String sdate = rs.getString(4);
                String edate = rs.getString(5);
                String done = rs.getString(6);
                todo = new Todo(num, content, id, sdate, edate, done);
            }
//            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return todo;
    }

    @Override
    public void insert(Todo todo) {
        try {
            Connection con = util.getConnection();
            String q = "INSERT INTO todolist (`content`, `id`, `sdate`, `edate`, `done`) VALUES (?, ?, sysdate(), ?, 'N');";

            PreparedStatement stat = con.prepareStatement(q);
            stat.setString(1, todo.getContent());
            stat.setString(2, todo.getId());
            stat.setString(3, todo.getEdate());

            stat.executeUpdate();
//            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(String num) {
        try {
            String q = "delete from todolist where num = ?";
            Connection con = util.getConnection();// pool에서 한개 빌려옴
            PreparedStatement stat = con.prepareStatement(q);
            stat.setString(1, num);// ?에 setting

            stat.executeUpdate();
//            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAll() {
        try {
            String q = "delete from todolist";
            Connection con = util.getConnection();// pool에서 한개 빌려옴
            PreparedStatement stat = con.prepareStatement(q);

            stat.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void done(String num) {
        try {
            String q = "update todolist set done = 'Y' where num = ?";
            Connection con = util.getConnection();// pool에서 한개 빌려옴
            PreparedStatement stat = con.prepareStatement(q);
            stat.setString(1, num);// ?에 setting

            stat.executeUpdate();// 실행
//            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
