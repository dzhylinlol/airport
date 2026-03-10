package com.solvd.airports.models.people;

import com.solvd.airports.exceptions.BadWeatherException;
import com.solvd.airports.models.planes.Weather;

public class Meteorologist extends Person {

    private String weatherStation;
    private double forecastAccuracy;

    public Meteorologist() {
    }

    public Meteorologist(Long id,
                         String firstName,
                         String lastName,
                         String weatherStation,
                         double forecastAccuracy) {
        super(id, firstName, lastName);
        this.weatherStation = weatherStation;
        this.forecastAccuracy = forecastAccuracy;
    }

    public void checkWeather(Weather weather) throws BadWeatherException {
        if (!weather.isFlyable()) {
            throw new BadWeatherException("Weather is not flyable!");
        }
    }
    public String getWeatherStation() {
        return weatherStation;
    }
    public void setWeatherStation(String weatherStation) {
        this.weatherStation = weatherStation;
    }
    public double getForecastAccuracy() {
        return forecastAccuracy;
    }
    public void setForecastAccuracy(double forecastAccuracy) {
        this.forecastAccuracy = forecastAccuracy;
    }

    @Override
    public String getRole() {
        return "Meteorologist" + getFirstName() + " " + getLastName();
    }


}
