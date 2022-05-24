package com.happyhouse.weather.controller;

import com.happyhouse.weather.domain.Weather;
import com.happyhouse.weather.service.WeatherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/weather")
@Api(value = "Weather", tags = {"날씨 제공 API"})
@CrossOrigin("*")
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @GetMapping("/{name}")
    @ApiOperation(value = "날씨 정보", notes = "해당하는 아파트명이 있으면 해당 아파트의 지역 날씨 검색, 없다면 해당 지역 날씨 검색", response = List.class)
    public ResponseEntity<Weather> parseAPT(@PathVariable(name = "name") String query) throws IOException {
        query = weatherService.getDongbyQuery(query);
        Weather news = weatherService.getWeather(query);
        return new ResponseEntity<>(news, HttpStatus.OK);
    }
}
