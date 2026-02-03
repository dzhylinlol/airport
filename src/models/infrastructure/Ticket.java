package models.infrastructure;

import models.people.Passenger;

public class Ticket {
    private String number;
    private String flightNumber;
    private Passenger passenger;
    private String seatNumber;

    public Ticket() {};

    public Ticket(String number,
                  String flightNumber,
                  String seatNumber,
                  Passenger passenger) {
        this.number = number;
        this.flightNumber = flightNumber;
        this.seatNumber = seatNumber;
        this.passenger = passenger;
    }

    @Override
    public String toString() {
        return "Ticket: " + number + " " + flightNumber + " " + seatNumber + " " + passenger;
    }

    public void bookedBy(Passenger passenger) {
        this.passenger = passenger;
    }

    public void bookedBy(Long id, String name, String surname) {
       this.passenger = new Passenger(id, name, surname, this.number);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}

