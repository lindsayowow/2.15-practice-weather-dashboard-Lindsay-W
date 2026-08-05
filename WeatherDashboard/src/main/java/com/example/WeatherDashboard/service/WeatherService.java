package com.example.WeatherDashboard.service;

import com.WeatherDashboard.config.WeatherAPIConfig;
import com.example.WeatherDashboard.model.WeatherInfo;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.JsonNode;


@Service
public class WeatherService {

    private final WeatherAPIConfig apiConfig;
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

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

    public WeatherInfo getWeatherInfo(String city) {
        String json = getRawWeatherJson(city);
        JsonNode root = objectMapper.readTree(json);

        String cityName = root.path("name").asString();
        double temperature = root.path("main").path("temp").asDouble();
        int humidity = root.path("main").path("humidity").asInt();
        String description = root.path("weather").get(0).path("description").asText();

        return new WeatherInfo(cityName, temperature, humidity, description);
    }

}
