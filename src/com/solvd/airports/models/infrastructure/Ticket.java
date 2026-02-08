package com.solvd.airports.models.infrastructure;

public class Ticket {
    private String number;
    private Flight flight;
    private String seatNumber;

    public Ticket() {};

    public Ticket(String number,
                  Flight flight,
                  String seatNumber){
        this.number = number;
        this.flight = flight;
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString() {
        return "Ticket: " + number + " " + flight.getId() + " " + seatNumber ;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

}

