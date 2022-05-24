package com.happyhouse.house.service;

import com.happyhouse.house.domain.HouseInfoDto;
import com.happyhouse.house.domain.SidoGugunCodeDto;

import java.util.ArrayList;
import java.util.List;

public interface HouseMapService {

    List<SidoGugunCodeDto> getSido() throws Exception;

    List<SidoGugunCodeDto> getGugunInSido(String sido) throws Exception;

    List<HouseInfoDto> getDongInGugun(String gugun) throws Exception;

    ArrayList<HouseInfoDto> getAllHouseDeal(int page);

    HouseInfoDto getHouseDealByNo(String no);

    ArrayList<HouseInfoDto> getAPTByCode(String code, int page);

    ArrayList<HouseInfoDto> getDongByCode(String code, int page);

    ArrayList<HouseInfoDto> getAPTByNamePaging(String name, int page);

    ArrayList<HouseInfoDto> getDongByNamePaging(String name, int page);

    ArrayList<HouseInfoDto> getAPTByName(String name);

    ArrayList<HouseInfoDto> getDongByName(String name);

    int getAllHouseDealCount();

    int getAPTByCodeCount(String code);

    int getDongByCodeCount(String code);

    int getAPTByNameCount(String name);

    int getDongByNameCount(String name);

    ArrayList<HouseInfoDto> getDealInfoByApt(String name);

    ArrayList<HouseInfoDto> getDealInfoByDong(String name);

    ArrayList<SidoGugunCodeDto> getBaseAddress();
}
