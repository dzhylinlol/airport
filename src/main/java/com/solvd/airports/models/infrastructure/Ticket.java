package com.solvd.airports.models.infrastructure;

public class Ticket {
    private String number;
    private Long flightId;
    private String seat;

    public Ticket() {};

    public Ticket(String number,
                  Long flightId,
                  String seat){
        this.number = number;
        this.flightId = flightId;
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "Ticket: " + number + " " + seat;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

//    public Flight getFlight() {
//        return flight;
//    }

//    public void setFlight(Flight flight) {
//        this.flight = flight;
//    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

}

