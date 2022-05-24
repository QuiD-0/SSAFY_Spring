package com.happyhouse.weather.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Weather {

    String location;
    String temperature;
    String delta;
    String weather;
    String humidity;
    String wind;
    String windSpeed;

    public Weather(String location, String temperature, String delta, String weather, String humidity, String wind, String windSpeed) {
        this.location = location;
        this.temperature = temperature;
        this.delta = delta;
        this.weather = weather;
        this.humidity = humidity;
        this.wind = wind;
        this.windSpeed = windSpeed;
    }
}
