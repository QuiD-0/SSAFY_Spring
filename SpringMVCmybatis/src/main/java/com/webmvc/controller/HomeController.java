package com.webmvc.controller;

import com.webmvc.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;


@Controller
public class HomeController {

    @Autowired
    BoardService boardService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
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
    public String loginProcess(String id,String pw, HttpSession httpSession) {
        // db체크
        if(boardService.checkPW(id,pw)!=0){
            httpSession.setAttribute("id", id);
        }
        return "redirect:list";

    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.setAttribute("id", null);

        return "redirect:list";
    }

}
