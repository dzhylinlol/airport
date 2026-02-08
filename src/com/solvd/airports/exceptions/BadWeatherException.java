package com.solvd.airports.exceptions;

public class BadWeatherException extends RuntimeException {
    public BadWeatherException(String message) {
        super(message);
    }
}
