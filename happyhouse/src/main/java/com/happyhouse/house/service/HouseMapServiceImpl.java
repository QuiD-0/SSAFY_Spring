package com.happyhouse.house.service;

import com.happyhouse.house.domain.HouseInfoDto;
import com.happyhouse.house.domain.SidoGugunCodeDto;
import com.happyhouse.house.repository.HouseMapMapper;
import com.happyhouse.util.Translate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class HouseMapServiceImpl implements HouseMapService {

    @Autowired
    private HouseMapMapper houseMapMapper;

    @Override
    public List<SidoGugunCodeDto> getSido() throws Exception {
        return houseMapMapper.getSido();
    }

    @Override
    public List<SidoGugunCodeDto> getGugunInSido(String sido) throws Exception {
        return houseMapMapper.getGugunInSido(sido);
    }

    @Override
    public List<HouseInfoDto> getDongInGugun(String gugun) throws Exception {
        return houseMapMapper.getDongInGugun(gugun);
    }

    @Override
    public ArrayList<SidoGugunCodeDto> getBaseAddress() {
        return houseMapMapper.getBase();
    }
    @Override
    public ArrayList<HouseInfoDto> getAllHouseDeal(int page) {
        return houseMapMapper.findAllHouseDeal(page);
    }

    @Override
    public HouseInfoDto getHouseDealByNo(String no) {
        return houseMapMapper.findHouseDealByNo(no);
    }

    @Override
    public ArrayList<HouseInfoDto> getAPTByCode(String code, int page) {
        HashMap map = new HashMap();
        map.put("code", code);
        map.put("page", page);
        return houseMapMapper.findAPTByCode(map);
    }

    @Override
    public ArrayList<HouseInfoDto> getDongByCode(String code, int page) {
        HashMap map = new HashMap();
        map.put("code", code);
        map.put("page", page);
        return houseMapMapper.findDongByCode(map);
    }

    @Override
    public ArrayList<HouseInfoDto> getAPTByNamePaging(String name, int page) {
        name = Translate.EngToKor(name);
        HashMap map = new HashMap();
        map.put("name", name);
        map.put("page", page);
        return houseMapMapper.findAPTByNamePaging(map);
    }

    @Override
    public ArrayList<HouseInfoDto> getDongByNamePaging(String name, int page) {
        name = Translate.EngToKor(name);
        HashMap map = new HashMap();
        map.put("name", name);
        map.put("page", page);
        return houseMapMapper.findDongByNamePaging(map);
    }

    @Override
    public ArrayList<HouseInfoDto> getAPTByName(String name) {
        return houseMapMapper.findAPTByName(name);
    }

    @Override
    public ArrayList<HouseInfoDto> getDongByName(String name) {
        return houseMapMapper.findDongByName(name);
    }


    @Override
    public int getAllHouseDealCount() {
        return houseMapMapper.getAllHouseDealCount();
    }

    @Override
    public int getAPTByCodeCount(String code) {
        return houseMapMapper.getAPTByCodeCount(code);
    }

    @Override
    public int getDongByCodeCount(String code) {
        return houseMapMapper.getDongByCodeCount(code);
    }

    @Override
    public int getAPTByNameCount(String name) {
        name = Translate.EngToKor(name);
        return houseMapMapper.getAPTByNameCount(name);
    }

    @Override
    public int getDongByNameCount(String name) {
        name = Translate.EngToKor(name);
        return houseMapMapper.getDongByNameCount(name);
    }

    @Override
    public ArrayList<HouseInfoDto> getDealInfoByApt(String name) {
        name = Translate.EngToKor(name);
        return houseMapMapper.getDealInfoByApt(name);
    }

    @Override
    public ArrayList<HouseInfoDto> getDealInfoByDong(String name) {
        name = Translate.EngToKor(name);
        return houseMapMapper.getDealInfoByDong(name);
    }



}
