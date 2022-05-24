package com.happyhouse.weather.service;

import com.happyhouse.house.domain.HouseInfoDto;
import com.happyhouse.house.domain.SidoGugunCodeDto;
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
import java.util.Arrays;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    HouseMapService houseMapService;

    @Override
    public String getDongbyQuery(String query) {
        query = Translate.EngToKor(query);
        //아파트인 경우
        ArrayList<HouseInfoDto> apts = houseMapService.getAPTByName(query);
        ArrayList<SidoGugunCodeDto> base = houseMapService.getBaseAddress();
        if (apts.size() != 0) {
            HouseInfoDto apt = apts.get(0);
            query = apt.getGugunName();
        }
        for (SidoGugunCodeDto loc : base) {
            if (loc.getGugunName().indexOf(query) == 0) {
                query = loc.getGugunName();
                break;
            } else if (loc.getDongName().indexOf(query) == 0) {
                query = loc.getDongName();
                break;
            }
        }
        return query;
    }

    @Override
    public Weather getWeather(String query) throws IOException {
        String address = "https://search.naver.com/search.naver?sm=tab_hty.top&where=nexearch&query=" + query + "날씨";
        Document HTMLData = Jsoup.connect(address).timeout(5000).get();
        Elements document = HTMLData.select("section.sc_new.cs_weather_new._cs_weather > div._tab_flicking > div.content_wrap > div.open > div:nth-child(1) > div > div.weather_info");
        String[] summary = document.select("div.temperature_info > p").text().split(" ");
        String[] detailInfo = document.select("div.temperature_info > dl").text().split(" ");
        String temperature = document.select("div._today > div.weather_graphic > div.temperature_text > strong").text().replace("현재 온도", "");
        if (temperature.equals("")) {
            address = "https://search.naver.com/search.naver?sm=tab_hty.top&where=nexearch&query=서울날씨";
            HTMLData = Jsoup.connect(address).timeout(5000).get();
            document = HTMLData.select("section.sc_new.cs_weather_new._cs_weather > div._tab_flicking > div.content_wrap > div.open > div:nth-child(1) > div > div.weather_info");
            summary = document.select("div.temperature_info > p").text().split(" ");
            detailInfo = document.select("div.temperature_info > dl").text().split(" ");
            temperature = document.select("div._today > div.weather_graphic > div.temperature_text > strong").text().replace("현재 온도", "");
        }
        String delta = summary[0] + " " + summary[1] + " " + summary[2];
        String weather = summary[3];
        String humidity = detailInfo[1];
        String wind = detailInfo[2];
        String windSpeed = detailInfo[3];
        return new Weather(temperature, delta, weather, humidity, wind, windSpeed);
    }
}
