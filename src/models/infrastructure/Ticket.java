package models.infrastructure;

import models.people.Passenger;

public class Ticket {
    private String number;
    private String flightNumber;
    private String seatNumber;

    public Ticket() {};

    public Ticket(String number,
                  String flightNumber,
                  String seatNumber){
        this.number = number;
        this.flightNumber = flightNumber;
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString() {
        return "Ticket: " + number + " " + flightNumber + " " + seatNumber ;
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

}

