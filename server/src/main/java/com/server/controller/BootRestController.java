package com.server.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/")
public class BootRestController {

    @GetMapping
    public Map<String, String> hello() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "jean");
        map.put("age", "30");
        return map;
    }
}
