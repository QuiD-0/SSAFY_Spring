package com.boot.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {

    @GetMapping("/")
    public String test() {
        return "hello boot";
    }

    @GetMapping("/hello")
    public String test(Model model) {
        model.addAttribute("city","nia");
        return "hello";
    }
}
