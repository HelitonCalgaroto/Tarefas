package com.heliton.tarefas.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private String convertToCelsius(double temperatureInKelvin) {
        double temperatureCelsius = temperatureInKelvin - 273.15;
        return String.format("%.2f", temperatureCelsius);
    }

    public WeatherInfo getWeatherInfo(String latitude, String longitude) {
        String apiUrl = "https://api.openweathermap.org/data/2.5/weather?lat=" + latitude +
                "&lon=" + longitude + "&appid=69ff7d9c5ffe5b9cee371759b2aa863e";

        RestTemplate restTemplate = new RestTemplate();
        WeatherResponse weatherResponse = restTemplate.getForObject(apiUrl, WeatherResponse.class);

        if (weatherResponse != null && weatherResponse.getMain() != null) {
            double temperatureKelvin = weatherResponse.getMain().getTemp();
            String temperatureCelsius = convertToCelsius(temperatureKelvin);
            String description = weatherResponse.getWeather().get(0).getDescription();

            WeatherInfo weatherInfo = new WeatherInfo(temperatureCelsius, description);

            return weatherInfo;
        }

        return null;
    }
}
