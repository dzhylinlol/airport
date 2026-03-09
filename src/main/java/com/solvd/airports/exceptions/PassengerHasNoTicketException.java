package com.solvd.airports.exceptions;

public class PassengerHasNoTicketException extends Exception {
    public PassengerHasNoTicketException(String message) {
        super(message);
    }
}
