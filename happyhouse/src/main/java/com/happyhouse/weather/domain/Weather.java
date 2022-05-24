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

    String temperature;
    String summary;
    String detailInfo;

}
