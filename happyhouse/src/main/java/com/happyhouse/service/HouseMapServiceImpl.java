package com.happyhouse.service;

import com.happyhouse.domain.HouseInfoDto;
import com.happyhouse.domain.SidoGugunCodeDto;
import com.happyhouse.repository.HouseMapMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

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
    public List<HouseInfoDto> getAptInDong(String dong) throws Exception {
        return houseMapMapper.getAptInDong(dong);
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
        name = EngToKor(name);
        HashMap map = new HashMap();
        map.put("name", name);
        map.put("page", page);
        return houseMapMapper.findAPTByNamePaging(map);
    }

    @Override
    public ArrayList<HouseInfoDto> getDongByNamePaging(String name, int page) {
        name = EngToKor(name);
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
        name = EngToKor(name);
        return houseMapMapper.getAPTByNameCount(name);
    }

    @Override
    public int getDongByNameCount(String name) {
        name = EngToKor(name);
        return houseMapMapper.getDongByNameCount(name);
    }


    public String EngToKor(String word) {
        if (Pattern.matches("^[0-9a-zA-Z]*$", word)) {
            String clientId = "YOUR_CLIENT_ID";//애플리케이션 클라이언트 아이디값";
            String clientSecret = "YOUR_CLIENT_SECRET";//애플리케이션 클라이언트 시크릿값";

            String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
            String text;
            try {
                word = word.toUpperCase();
                text = URLEncoder.encode(word, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("인코딩 실패", e);
            }

            Map<String, String> requestHeaders = new HashMap<>();
            requestHeaders.put("X-Naver-Client-Id", "ubGrRSG3YIxiHqX7cRBw");
            requestHeaders.put("X-Naver-Client-Secret", "FMg16QIStA");

            String responseBody = post(apiURL, requestHeaders, text);
            JSONObject jObject = new JSONObject(responseBody);
            JSONObject message = jObject.getJSONObject("message");
            JSONObject result = message.getJSONObject("result");
            String translatedText = result.getString("translatedText");
            word = translatedText;
        }
        return word;
    }

    private static String post(String apiUrl, Map<String, String> requestHeaders, String text) {
        HttpURLConnection con = connect(apiUrl);
        String postParams = "source=en&target=ko&text=" + text; //원본언어: 한국어 (ko) -> 목적언어: 영어 (en)
        try {
            con.setRequestMethod("POST");
            for (Map.Entry<String, String> header : requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }

            con.setDoOutput(true);
            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                wr.write(postParams.getBytes());
                wr.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 응답
                return readBody(con.getInputStream());
            } else {  // 에러 응답
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
    }

    private static HttpURLConnection connect(String apiUrl) {
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection) url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }

    private static String readBody(InputStream body) {
        InputStreamReader streamReader = new InputStreamReader(body);

        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();

            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }

            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
        }
    }
}
