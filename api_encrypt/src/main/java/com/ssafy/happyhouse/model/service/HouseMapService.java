package com.ssafy.happyhouse.model.service;

import java.util.ArrayList;
import java.util.List;

import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.SidoGugunCodeDto;

public interface HouseMapService {

	List<SidoGugunCodeDto> getSido() throws Exception;
	List<SidoGugunCodeDto> getGugunInSido(String sido) throws Exception;
	List<HouseInfoDto> getDongInGugun(String gugun) throws Exception;
	List<HouseInfoDto> getAptInDong(String dong) throws Exception;
	ArrayList<HouseInfoDto> getAllHouseDeal(int page);

	HouseInfoDto getHouseDealByNo(String no);

	ArrayList<HouseInfoDto> getAPTByCode(String code, int page);

	ArrayList<HouseInfoDto> getDongByCode(String code, int page);

	ArrayList<HouseInfoDto> getAPTByName(String name, int page);

	ArrayList<HouseInfoDto> getDongByName(String name, int page);

	int getAllHouseDealCount();

	int getAPTByCodeCount(String code);

	int getDongByCodeCount(String code);

	int getAPTByNameCount(String name);

	int getDongByNameCount(String name);
}
