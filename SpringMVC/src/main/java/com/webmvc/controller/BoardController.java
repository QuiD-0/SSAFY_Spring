package com.webmvc.controller;

import com.webmvc.service.BoardService;
import com.webmvc.service.BoardServiceImpl;
import com.webmvc.vo.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

//FrontController에게서 요청을 넘겨 받아 Service한테 작업을 넘김
@Controller
public class BoardController {

    @Autowired
    BoardService service;// interface type

    // request < session < application
    public void list(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<Board> list = service.selectAll();// data 받음
        request.setAttribute("list", list);// request에 데이터 저장****

        // view로 넘어가기(forward 방식)
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/list.jsp");
        try {
            dispatcher.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void read(HttpServletRequest request, HttpServletResponse response) {
        String num = request.getParameter("num");
        Board b = service.selectOne(num);
        request.setAttribute("b", b);

        // view로 넘어가기(forward 방식)
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/read.jsp");
        try {
            dispatcher.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertForm(HttpServletRequest request, HttpServletResponse response) {
        HttpSession ses = request.getSession();
        System.out.println(request.getRequestURI());
        if (ses.getAttribute("id") == null) {
            ses.setAttribute("cpage", request.getRequestURI());
            loginForm(request, response);
        } else {
            // view로 넘어가기(forward 방식)
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/insertForm.jsp");
            try {
                dispatcher.forward(request, response);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void insertProcess(HttpServletRequest request, HttpServletResponse response) {
        try {
            //request.setCharacterEncoding("utf-8");front controller로 move

            // db에 insert
            String pass = request.getParameter("pass");
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            String name = request.getParameter("name");

            service.insert(new Board(null, pass, name, null, title, content, null));
            HttpSession ses = request.getSession();

            response.sendRedirect("list.bod");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void delete(HttpServletRequest request, HttpServletResponse response) {
        String num = request.getParameter("num");
        service.delete(num);

        // 초기화면으로 redirect
        try {
            response.sendRedirect("list.bod");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void loginForm(HttpServletRequest request, HttpServletResponse response) {// 로그인화면

        // view로 넘어가기(forward 방식)
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/loginForm.jsp");
        try {
            dispatcher.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 로그인 정보(id)를 세션에 저장함
    public void loginProcess(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");

        // 세션 얻기
        HttpSession session = request.getSession();
        session.setAttribute("id", id);

        // 초기화면으로 redirect
        String url = (String) session.getAttribute("cpage");
        if (url == null)
            url = "list.bod";
        // 초기화면으로 redirect
        try {
            response.sendRedirect(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void logout(HttpServletRequest request, HttpServletResponse response) {
        // 세션 얻기
        HttpSession session = request.getSession();
        session.setAttribute("id", null);

        // 초기화면으로 redirect
        try {
            response.sendRedirect("list.bod");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void index(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("list.bod");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
