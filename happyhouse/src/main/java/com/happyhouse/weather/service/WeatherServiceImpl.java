package com.happyhouse.weather.service;

import com.happyhouse.house.domain.HouseInfoDto;
import com.happyhouse.house.service.HouseMapService;
import com.happyhouse.util.Translate;
import com.happyhouse.weather.domain.Weather;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    HouseMapService houseMapService;

    @Override
    public String getDongbyQuery(String query) {
        query = Translate.EngToKor(query);
        ArrayList<HouseInfoDto> apts = houseMapService.getAPTByName(query);
        if (apts.size() != 0) {
            HouseInfoDto apt = apts.get(0);
            query = apt.getGugunName();
        }
        return query;
    }

    @Override
    public Weather getWeather(String query) throws IOException {
        String address = "https://search.naver.com/search.naver?sm=tab_hty.top&where=nexearch&query=" + query + "날씨";
        Document HTMLData = Jsoup.connect(address).timeout(5000).get();
        Elements document = HTMLData.select("section.sc_new.cs_weather_new._cs_weather > div._tab_flicking > div.content_wrap > div.open > div:nth-child(1) > div > div.weather_info");
        String temperature = document.select("div._today > div.weather_graphic > div.temperature_text > strong").text();
        String summary = document.select("div.temperature_info > p").text();
        String detailInfo = document.select("div.temperature_info > dl").text();
        System.out.println("temperature = " + temperature);
        System.out.println("summary = " + summary);
        System.out.println("detailInfo = " + detailInfo);
        return null;
    }
}
