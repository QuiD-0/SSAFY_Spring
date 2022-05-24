package com.happyhouse.house.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HouseInfoDto {

    private int aptCode;
    private String aptName;
    private String dongCode;
    private String dongName;
    private String sidoName;
    private String gugunName;
    private int buildYear;
    private String jibun;
    private String lat;
    private String lng;
    private String img;
    private String recentPrice;

    @Override
    public String toString() {
        return "HouseInfoDto [aptCode=" + aptCode + ", aptName=" + aptName + ", dongCode=" + dongCode + ", dongName="
                + dongName + ", sidoName=" + sidoName + ", gugunName=" + gugunName + ", buildYear=" + buildYear
                + ", jibun=" + jibun + ", lat=" + lat + ", lng=" + lng + ", img=" + img + ", recentPrice=" + recentPrice
                + "]";
    }

}
