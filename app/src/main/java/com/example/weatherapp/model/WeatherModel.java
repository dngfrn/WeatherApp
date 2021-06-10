package com.example.weatherapp.model;

public class WeatherModel {
    private LocationModel location;
    private CurrentModel current;
    private ConditionModel condition;
    private ForecastModel forecast;

    public ConditionModel getCondition() {
        return condition;
    }

    public void setCondition(ConditionModel condition) {
        this.condition = condition;
    }

    public ForecastModel getForecast() {
        return forecast;
    }

    public void setForecast(ForecastModel forecast) {
        this.forecast = forecast;
    }

    public LocationModel getLocation() {
        return location;
    }

    public void setLocation(LocationModel location) {
        this.location = location;
    }

    public CurrentModel getCurrent() {
        return current;
    }

    public void setCurrent(CurrentModel current) {
        this.current = current;
    }
}
