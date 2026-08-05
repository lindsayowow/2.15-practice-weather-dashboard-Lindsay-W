package com.example.WeatherDashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.example.WeatherDashboard.service.WeatherService;
import com.example.WeatherDashboard.model.WeatherInfo;


@SpringBootApplication
public class WeatherDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherDashboardApplication.class, args);
	}

	@Bean
	public CommandLineRunner testWeather(WeatherService weatherService) {
		return args -> {
			WeatherInfo info = weatherService.getWeatherInfo("London");
			System.out.println(info);
		};
	}

}
