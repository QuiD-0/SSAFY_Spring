package com.happyhouse.weather.service;

import com.happyhouse.weather.domain.Weather;

import java.io.IOException;

public interface WeatherService {
    String getDongbyQuery(String query);

    Weather getWeather(String query) throws IOException;
}
