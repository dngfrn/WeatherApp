package com.example.weatherapp.Retrofit;

import com.example.weatherapp.model.WeatherModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndpoint {
    @GET("current.json?key=2cbb105c03494630b37120150212905&q=Jakarta&aqi=no")
    Call<WeatherModel> getData();
    @GET("forecast.json?key=2cbb105c03494630b37120150212905&q=jakarta&days=3&aqi=no&alerts=no")
    Call<WeatherModel> getForecast();
}
