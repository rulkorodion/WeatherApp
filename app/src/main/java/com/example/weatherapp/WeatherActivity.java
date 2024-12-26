package com.example.weatherapp;

public class WeatherActivity {
    private String time;
    private String temperature;
    private String icon;
    private String feelsLike;

    public WeatherActivity(String time, String temperature, String icon, String feelsLike) {
        this.time = time;
        this.temperature = temperature;
        this.icon = icon;
        this.feelsLike = feelsLike;
    }

    public String getTime() {
        return time;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getIcon() {
        return icon;
    }

    public String getFeelsLike() {
        return feelsLike;
    }
}
