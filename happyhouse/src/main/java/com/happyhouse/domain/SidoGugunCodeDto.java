package com.happyhouse.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SidoGugunCodeDto {

    private String sidoCode;
    private String sidoName;
    private String gugunCode;
    private String gugunName;


    @Override
    public String toString() {
        return "SidoGugunCodeDto [sidoCode=" + sidoCode + ", sidoName=" + sidoName + ", gugunCode=" + gugunCode
                + ", gugunName=" + gugunName + "]";
    }

}
