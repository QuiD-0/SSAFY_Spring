package com.happyhouse.weather.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Weather {

    String location;
    String temperature;
    String delta;
    String weather;
    String humidity;
    String wind;
    String windSpeed;

}
