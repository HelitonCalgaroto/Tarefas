package com.heliton.tarefas.service;

public class WeatherInfo {
    private String temperature;
    private String description;

    public WeatherInfo() {
    }

    public WeatherInfo(String temperature, String description) {
        this.temperature = temperature;
        this.description = description;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
