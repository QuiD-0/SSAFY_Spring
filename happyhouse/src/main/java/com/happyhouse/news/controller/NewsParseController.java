package com.happyhouse.news.controller;

import com.happyhouse.news.domain.News;
import com.happyhouse.news.service.NewsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/news")
@Api(value = "News", tags = {"뉴스 크롤링 API"})
@CrossOrigin("*")
public class NewsParseController {

    @Autowired
    NewsService newsService;

    @GetMapping("/{name}")
    @ApiOperation(value = "뉴스 리스트",notes = "해당하는 아파트명이 있으면 해당 아파트의 지역 검색, 없다면 바로 지역검색", response = List.class)
    public ResponseEntity<HashMap> parseAPT(@PathVariable(name = "name") String query) throws IOException {
        query = newsService.getDongbyQuery(query);
        HashMap news = newsService.getNews(query);
        return new ResponseEntity<>(news, HttpStatus.OK);
    }
}
