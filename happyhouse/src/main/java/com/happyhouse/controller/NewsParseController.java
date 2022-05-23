package com.happyhouse.controller;

import com.happyhouse.domain.HouseInfoDto;
import com.happyhouse.domain.News;
import com.happyhouse.service.HouseMapService;
import com.happyhouse.service.NewsService;
import com.happyhouse.util.Translate;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("/news")
public class NewsParseController {

    @Autowired
    NewsService newsService;

    @GetMapping("/{name}")
    public ResponseEntity<ArrayList<News>> parseAPT(@PathVariable(name = "name") String query) throws IOException {
        query = newsService.getDongbyQuery(query);
        ArrayList<News> news = newsService.getNews(query);
        return new ResponseEntity<>(news, HttpStatus.OK);
    }
}
