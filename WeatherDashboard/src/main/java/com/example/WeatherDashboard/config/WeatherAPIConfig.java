package com.example.WeatherDashboard.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WeatherAPIConfig {

    @Value("${WEATHER_API_KEY}")
    private String apiKey;

    public String getApiKey() {
        return apiKey;
    }
}

