package com.heliton.tarefas.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.heliton.tarefas.models.WeatherData;

@Service
public class WeatherService {

    @Value("${openweather.api.key}")
    private String apiKey;

    public WeatherData getWeatherData(String latitude, String longitude) {
        String apiUrl = "https://api.openweathermap.org/data/3.0/onecall?lat=" + latitude +
                "&lon=" + longitude + "&exclude={part}&appid=" + apiKey;

        RestTemplate restTemplate = new RestTemplate();
        WeatherData weatherData = restTemplate.getForObject(apiUrl, WeatherData.class);

        return weatherData;
    }
}