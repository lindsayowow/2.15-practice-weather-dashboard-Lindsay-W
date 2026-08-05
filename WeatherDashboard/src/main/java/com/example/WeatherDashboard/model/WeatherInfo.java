package com.example.WeatherDashboard.model;

public class WeatherInfo {

    private String city;
    private double temperature;
    private int humidity;
    private String description;

    // constructor
    public WeatherInfo(String city, double temperature, int humidity, String description) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
        this.description = description;
    }

    //getters and setters
    public String getCity() {
        return city;
    }

    public double getTemperature() {
        return temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "City: " + city + "\n" +
                "Temperature: " + temperature + " °C\n" +
                "Humidity: " + humidity + "%\n" +
                "Conditions: " + description;
    }
}
