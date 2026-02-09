package com.solvd.airports.models.infrastructure;

public class Ticket {
    private String number;
    private Long flightId;
    private String seatNumber;

    public Ticket() {};

    public Ticket(String number,
                  Long flightId,
                  String seatNumber){
        this.number = number;
        this.flightId = flightId;
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString() {
        return "Ticket: " + number + " " + seatNumber ;
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

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

}

