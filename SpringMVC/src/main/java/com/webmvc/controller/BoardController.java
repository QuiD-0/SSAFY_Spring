package com.webmvc.controller;

import com.webmvc.service.BoardService;
import com.webmvc.vo.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

//FrontController에게서 요청을 넘겨 받아 Service한테 작업을 넘김
@Controller
public class BoardController {

    @Autowired
    BoardService boardService;// interface type

    // request < session < application
    @GetMapping("/list")
    public String list(Model model) {
        ArrayList<Board> list = boardService.selectAll();// data 받음
        model.addAttribute("list", list);// request에 데이터 저장****
        return "list";
    }

    @GetMapping("/read")
    public String read(String num, Model model) {
        Board b = boardService.selectOne(num);
        model.addAttribute("b", b);
        return "read";
    }

    @GetMapping("/insertForm")
    public String insertForm() {
        return "insert";

    }

    @PostMapping("/insertProcess")
    public String insertProcess(Board board) {
        boardService.insert(board);
        return "redirect:list";

    }

    @GetMapping("/delete")
    public String delete(String num) {
        boardService.delete(num);
        return "redirect:list";
    }

    @GetMapping("/loginForm")
    public String loginForm(HttpSession httpSession) {// 로그인화면
        if (httpSession.getAttribute("id") == null) {
            return "loginForm";
        } else {
            return "list";
        }
    }

    @PostMapping("/loginProcess")
    public String loginProcess(String id, HttpSession httpSession) {

        // 세션 얻기
        httpSession.setAttribute("id", id);

        return "redirect:list";

    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.setAttribute("id", null);

        return "redirect:list";
    }

    @GetMapping("/search")
    public String search(String word,String condition,Model model){
        ArrayList<Board> list = boardService.search(word,condition);// data 받음
        model.addAttribute("list", list);// request에 데이터 저장****
        return "list";
    }


}
