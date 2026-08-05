package com.example.WeatherDashboard.service;

import com.WeatherDashboard.config.WeatherAPIConfig;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private final WeatherAPIConfig apiConfig;
    private final RestTemplate restTemplate = new RestTemplate();

    public WeatherService(WeatherAPIConfig apiConfig) {
        this.apiConfig = apiConfig;
    }

    public String getRawWeatherJson(String city) {
        String url = "https://api.openweathermap.org/data/2.5/weather"
                + "?q=" + city
                + "&appid=" + apiConfig.getApiKey()
                + "&units=metric";

        return restTemplate.getForObject(url, String.class);
    }
}
