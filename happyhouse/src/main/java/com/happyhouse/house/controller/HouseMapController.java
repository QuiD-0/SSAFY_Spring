package com.happyhouse.house.controller;

import com.happyhouse.house.domain.HouseInfoDto;
import com.happyhouse.house.domain.SidoGugunCodeDto;
import com.happyhouse.house.service.HouseMapService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Api(tags = {"거래정보 및 도시,군별 아파트 API 정보를 제공"})
@RestController
@RequestMapping("/house")
@CrossOrigin("*")
public class HouseMapController {

    private final Logger logger = LoggerFactory.getLogger(HouseMapController.class);

    @Autowired
    private HouseMapService HouseMapService;

    @ApiOperation(value = "시, 도를 반환")
    @GetMapping("/sido")
    public ResponseEntity<List<SidoGugunCodeDto>> sido() throws Exception {
        logger.debug("sido : {}", HouseMapService.getSido());
        return new ResponseEntity<List<SidoGugunCodeDto>>(HouseMapService.getSido(), HttpStatus.OK);
    }

    @ApiOperation(value = "구군 검색")
    @GetMapping("/gugun/{sido}")
    public ResponseEntity<List<SidoGugunCodeDto>> gugun(@PathVariable(name = "sido") String sido) throws Exception {
        return new ResponseEntity<List<SidoGugunCodeDto>>(HouseMapService.getGugunInSido(sido), HttpStatus.OK);
    }

    @ApiOperation(value = "동 검색")
    @GetMapping("/dong/{gugun}")
    public ResponseEntity<List<HouseInfoDto>> dong(@PathVariable(name = "gugun") String gugun) throws Exception {
        return new ResponseEntity<List<HouseInfoDto>>(HouseMapService.getDongInGugun(gugun), HttpStatus.OK);
    }

    @ApiOperation(value = "아파트 검색")
    @GetMapping("/apt/{dong}")
    public ResponseEntity<List<HouseInfoDto>> apt(@PathVariable(name = "dong") String dong) throws Exception {
        return new ResponseEntity<List<HouseInfoDto>>(HouseMapService.getAptInDong(dong), HttpStatus.OK);
    }

    @ApiOperation(value = "모든 거래정보 검색")
    @GetMapping("/{page}")
    public ResponseEntity<HashMap> all(@PathVariable(name = "page") int page, HttpServletRequest request) {
        HashMap map = new HashMap();
        map.put("item", HouseMapService.getAllHouseDeal((page - 1) * 5));
        map.put("maxPage", (HouseMapService.getAllHouseDealCount() - 1) / 5 + 1);
        return new ResponseEntity<HashMap>(map, HttpStatus.OK);
    }

    @ApiOperation(value = "거래 번호 검색")
    @GetMapping("/deal/{no}")
    public ResponseEntity<HouseInfoDto> aptByNo(@PathVariable(name = "no") String no) {
        return new ResponseEntity<HouseInfoDto>(HouseMapService.getHouseDealByNo(no), HttpStatus.OK);
    }

    @ApiOperation(value = "아파트로 코드 검색")
    @GetMapping("/aptcode/{code}/{page}")
    public ResponseEntity<HashMap> aptByCode(@PathVariable(name = "code") String code, @PathVariable(name = "page") int page) {
        HashMap map = new HashMap();
        map.put("item", HouseMapService.getAPTByCode(code, (page - 1) * 5));
        map.put("maxPage", (HouseMapService.getAPTByCodeCount(code) - 1) / 5 + 1);
        return new ResponseEntity<HashMap>(map, HttpStatus.OK);
    }

    @ApiOperation(value = "동코드로 검색")
    @GetMapping("/dongcode/{code}/{page}")
    public ResponseEntity<HashMap> dongByCode(@PathVariable(name = "code") String code, @PathVariable(name = "page") int page) {
        HashMap map = new HashMap();
        map.put("item", HouseMapService.getDongByCode(code, (page - 1) * 5));
        map.put("maxPage", (HouseMapService.getDongByCodeCount(code) - 1) / 5 + 1);
        return new ResponseEntity<HashMap>(map, HttpStatus.OK);
    }

    @ApiOperation(value = "아파트 이름으로 검색")
    @GetMapping("/aptname/{name}/{page}")
    public ResponseEntity<HashMap> aptByName(@PathVariable(name = "name") String name, @PathVariable(name = "page") int page) {
        HashMap map = new HashMap();
        map.put("item", HouseMapService.getAPTByNamePaging(name, (page - 1) * 5));
        map.put("maxPage", (HouseMapService.getAPTByNameCount(name) - 1) / 5 + 1);
        return new ResponseEntity<HashMap>(map, HttpStatus.OK);
    }

    @ApiOperation(value = "동 이름으로 검색 / 페이징")
    @GetMapping("/dongname/{name}/{page}")
    public ResponseEntity<HashMap> dongByNamePaging(@PathVariable(name = "name") String name, @PathVariable(name = "page") int page) {
        HashMap map = new HashMap();
        map.put("item", HouseMapService.getDongByNamePaging(name, (page - 1) * 5));
        map.put("maxPage", (HouseMapService.getDongByNameCount(name) - 1) / 5 + 1);
        return new ResponseEntity<HashMap>(map, HttpStatus.OK);
    }

    @ApiOperation(value = "동 이름으로 검색")
    @GetMapping("/dongname/{name}")
    public ResponseEntity<?> dongByName(@PathVariable(name = "name") String name) {
        ArrayList<HouseInfoDto> list = HouseMapService.getDongByName(name);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @ApiOperation(value = "아파트 이름으로 검색")
    @GetMapping("/aptname/{name}")
    public ResponseEntity<?> aptByName(@PathVariable(name = "name") String name) {
        ArrayList<HouseInfoDto> list = HouseMapService.getAPTByName(name);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @ApiOperation(value = "아파트 이름으로 검색")
    @GetMapping("/deal/apt/{name}")
    public ResponseEntity<?> dealInfoByApt(@PathVariable(name = "name") String name) {
        ArrayList<HouseInfoDto> list = HouseMapService.getDealInfoByApt(name);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @ApiOperation(value = "아파트 이름으로 검색")
    @GetMapping("/deal/dong/{name}")
    public ResponseEntity<?> dealInfoByDong(@PathVariable(name = "name") String name) {
        ArrayList<HouseInfoDto> list = HouseMapService.getDealInfoByDong(name);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
