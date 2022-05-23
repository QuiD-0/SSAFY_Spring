package com.happyhouse.service;

import com.happyhouse.domain.HouseInfoDto;
import com.happyhouse.domain.News;
import com.happyhouse.util.Translate;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class NewsServiceImpl implements NewsService{

    @Autowired
    HouseMapService houseMapService;

    @Override
    public ArrayList<News> getNews(String query) throws IOException {
        ArrayList<News> news = new ArrayList<>();
        String address = "https://search.naver.com/search.naver?where=news&query=" + query + "&sm=tab_opt&sort=0&photo=3&field=0&pd=1&ds=&de=&docid=&related=0&mynews=0&office_type=0&office_section_code=0&news_office_checked=&nso=so%3Ar%2Cp%3A1w&is_sug_officeid=0";
        Document HTMLData = Jsoup.connect(address).timeout(5000).get();
        Elements document = HTMLData.select(".bx");

        for (Element element : document) {
            String URL = element.select(".news_tit").attr("href");
            String TITLE = element.select(".news_tit").attr("title");
            String publisher = element.select("div > div > div.news_info > div.info_group > a.info.press").text().replace("선정", "").strip();
            String time = element.select("div.news_wrap.api_ani_send > div > div.news_info > div.info_group > span:nth-child(3)").text();
            String description = element.select("div.news_wrap.api_ani_send > div > div.news_dsc > div > a").text();
            if (URL.equals("")) continue;
            news.add(new News(URL, TITLE, description, publisher, time));
        }
        return news;
    }

    @Override
    public String getDongbyQuery(String query) {
        query = Translate.EngToKor(query);
        ArrayList<HouseInfoDto> apts = houseMapService.getAPTByName(query);
        if(apts.size()!=0){
            HouseInfoDto apt = apts.get(0);
            query = apt.getGugunName();
        }
        return query;
    }
}
