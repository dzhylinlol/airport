package com.solvd.airports.exceptions;

public class PassengerHasNoTicketException extends RuntimeException {
    public PassengerHasNoTicketException(String message) {
        super(message);
    }
}
