package com.solvd.airports.exceptions;

public class SeatsExceededException extends RuntimeException {
    public SeatsExceededException(String message) {
        super(message);
    }
}
