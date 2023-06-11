package com.heliton.tarefas.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WeatherService {

    private final WebClient webClient;

    @Value("${openweather.api.key}")
    private String apiKey;

    public WeatherService() {
        this.webClient = WebClient.create();
    }

//    public WeatherData getWeatherData(String location) {
//        String url = String.format("https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s", location, apiKey);
//
//        return webClient.get()
//                .uri(url)
//                .retrieve()
//                .bodyToMono(WeatherData.class)
//                .block(); // Blocking call, suitable for simplicity in this example
//    }
}