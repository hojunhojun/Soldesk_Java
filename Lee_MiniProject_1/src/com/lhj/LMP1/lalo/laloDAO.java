package com.lhj.LMP1.lalo;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class laloDAO {
    
    public String[] getLalo(String addr) {
        HttpsURLConnection huc = null;
        
        try {
            String search = URLEncoder.encode(addr, "utf-8");
            String s = "https://dapi.kakao.com/v2/local/search/address.json?query=" + search;
            URL u = URI.create(s).toURL();
            huc = (HttpsURLConnection) u.openConnection();

            huc.setRequestProperty("Authorization", "내 인증키 입력");

            try (InputStream is = huc.getInputStream();
                 InputStreamReader isr = new InputStreamReader(is, "utf-8")) {
                
                JSONParser jp = new JSONParser();
                JSONObject jo = (JSONObject) jp.parse(isr);
                JSONArray ja = (JSONArray) jo.get("documents");

                JSONObject jo2 = (JSONObject) ja.get(0);
                String x = (String) jo2.get("x");
                String y = (String) jo2.get("y");
                String z = (String) jo2.get("address_name");

                return new String[] { y, x, z };
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        huc.disconnect();
        return null;
    }
}
