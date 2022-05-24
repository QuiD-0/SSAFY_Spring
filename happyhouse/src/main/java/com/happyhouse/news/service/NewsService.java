package com.happyhouse.news.service;

import java.io.IOException;
import java.util.HashMap;

public interface NewsService {

    HashMap getNews(String query) throws IOException;

    String getDongbyQuery(String query);
}
