package com.happyhouse.util;

import com.happyhouse.domain.News;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
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
public class NewsParser {

    @GetMapping("/{name}")
    public ResponseEntity<ArrayList<News>> parse(@PathVariable(name = "name") String query) throws IOException {
        query = Translate.EngToKor(query);
        ArrayList<News> news = new ArrayList<>();

        String address = "https://search.naver.com/search.naver?where=news&query=" + query + "&sm=tab_opt&sort=0&photo=0&field=0&pd=1&ds=&de=&docid=&related=0&mynews=0&office_type=0&office_section_code=0&news_office_checked=&nso=so%3Ar%2Cp%3A1w&is_sug_officeid=0";
        Document HTMLData = Jsoup.connect(address).timeout(5000).get();
        Elements document = HTMLData.select(".bx");

        for (Element element : document) {
            String URL = element.select(".news_tit").attr("href");
            String TITLE = element.select(".news_tit").attr("title");
            String publisher = element.select(".info.press").text();
            String time = element.select("div.news_wrap.api_ani_send > div > div.news_info > div.info_group > span").text();
            if (URL.equals("")) continue;
            news.add(new News(URL, TITLE, publisher, time));
        }
        return new ResponseEntity<>(news, HttpStatus.OK);
    }
}
