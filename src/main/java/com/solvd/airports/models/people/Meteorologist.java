package com.solvd.airports.models.people;

import com.solvd.airports.exceptions.BadWeatherException;
import com.solvd.airports.models.planes.Weather;

public class Meteorologist extends Person {

    // добавить норм проперти

    public Meteorologist() {
    }

    public Meteorologist(Long id,
                         String firstName,
                         String lastName) {
        super(id, firstName, lastName);
    }

    @Override
    public String getRole() {
        return "Meteorologist" + getFirstName() + " " + getLastName();
    }

    public void checkWeather(Weather weather) throws BadWeatherException {
        if (!weather.isFlyable()) {
            throw new BadWeatherException("Weather is not flyable!");
        }
    }
}
