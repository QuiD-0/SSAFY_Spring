package com.happyhouse.house.repository;

import com.happyhouse.house.domain.HouseInfoDto;
import com.happyhouse.house.domain.SidoGugunCodeDto;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Mapper
public interface HouseMapMapper {

    List<SidoGugunCodeDto> getSido() throws SQLException;

    List<SidoGugunCodeDto> getGugunInSido(String sido) throws SQLException;

    List<HouseInfoDto> getDongInGugun(String gugun) throws SQLException;

    ArrayList<HouseInfoDto> findAllHouseDeal(int page);

    HouseInfoDto findHouseDealByNo(String no);

    ArrayList<HouseInfoDto> findAPTByCode(HashMap map);

    ArrayList<HouseInfoDto> findDongByCode(HashMap map);

    ArrayList<HouseInfoDto> findAPTByName(String name);

    ArrayList<HouseInfoDto> findDongByName(String name);

    int getAllHouseDealCount();

    int getAPTByCodeCount(String code);

    int getDongByCodeCount(String code);

    int getAPTByNameCount(String name);

    int getDongByNameCount(String name);

    ArrayList<HouseInfoDto> findDongByNamePaging(HashMap map);

    ArrayList<HouseInfoDto> findAPTByNamePaging(HashMap map);

    ArrayList<HouseInfoDto> getDealInfoByApt(String name);

    ArrayList<HouseInfoDto> getDealInfoByDong(String name);

    ArrayList<SidoGugunCodeDto> getBase();
}
