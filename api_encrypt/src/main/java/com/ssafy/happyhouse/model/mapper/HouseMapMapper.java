package com.ssafy.happyhouse.model.mapper;

import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.SidoGugunCodeDto;
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

    List<HouseInfoDto> getAptInDong(String dong) throws SQLException;

    ArrayList<HouseInfoDto> findAllHouseDeal(int page);

    HouseInfoDto findHouseDealByNo(String no);

    ArrayList<HouseInfoDto> findAPTByCode(HashMap map);

    ArrayList<HouseInfoDto> findDongByCode(HashMap map);

    ArrayList<HouseInfoDto> findAPTByName(HashMap map);

    ArrayList<HouseInfoDto> findDongByName(HashMap map);

    int getAllHouseDealCount();

    int getAPTByCodeCount(String code);

    int getDongByCodeCount(String code);

    int getAPTByNameCount(String name);

    int getDongByNameCount(String name);
}
