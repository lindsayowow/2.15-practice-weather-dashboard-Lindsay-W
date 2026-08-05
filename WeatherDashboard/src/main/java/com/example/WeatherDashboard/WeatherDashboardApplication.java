package com.example.WeatherDashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.example.WeatherDashboard.service.WeatherService;
import com.example.WeatherDashboard.model.WeatherInfo;

import java.util.Scanner;


@SpringBootApplication
public class WeatherDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherDashboardApplication.class, args);
	}

	@Bean
	public CommandLineRunner testWeather(WeatherService weatherService) {
		return args -> {
			Scanner scanner = new Scanner(System.in);

			while (true) {
				System.out.print("Enter a city (or type 'exit' to quit): ");
				String city = scanner.nextLine();

				if (city.equalsIgnoreCase("exit")) {
					break;
				}

				WeatherInfo info = weatherService.getWeatherInfo(city);
				System.out.println(info);
				System.out.println();
			}

		};
	}


}
