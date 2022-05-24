package com.happyhouse.news.service;

import com.happyhouse.news.domain.News;

import java.io.IOException;
import java.util.ArrayList;

public interface NewsService {

    ArrayList<News> getNews(String query) throws IOException;

    String getDongbyQuery(String query);
}
