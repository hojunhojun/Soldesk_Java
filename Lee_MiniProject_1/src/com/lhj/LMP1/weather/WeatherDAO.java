package com.lhj.LMP1.weather;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class WeatherDAO {
    
    public String[] getWeather(String lat, String lon, String addr) {
        HttpsURLConnection huc = null;
        try {
            String s = "https://api.openweathermap.org/data/2.5/weather?lat=" + lat 
                        + "&lon=" + lon + "&appid=인증키 입력&units=metric&lang=kr";

            URL u = URI.create(s).toURL();
            huc = (HttpsURLConnection) u.openConnection();

            try (InputStream is = huc.getInputStream();
                 InputStreamReader isr = new InputStreamReader(is, "utf-8")) {

                JSONParser jp = new JSONParser();
                JSONObject jo = (JSONObject) jp.parse(isr);
                JSONArray ja = (JSONArray) jo.get("weather");
                JSONObject weather = (JSONObject) ja.get(0);
                String description = (String) weather.get("description");

                JSONObject main = (JSONObject) jo.get("main");
                Double temp = (Double) main.get("temp");
                Double feelsLike = (Double) main.get("feels_like");

                return new String[] { description, temp.toString(), feelsLike.toString() };
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        huc.disconnect();
        return null;
    }
}
