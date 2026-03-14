package com.solvd.airports.models.infrastructure;

public class Ticket {
    private String number;
    private Long flightId;
    private String seat;
    private TicketClass ticketClass;

    public Ticket() {};

    public Ticket(String number,
                  Long flightId,
                  String seat) {
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

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public Long getFlightId() {
        return flightId;
    }
    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }
    public TicketClass getTicketClass() {
        return ticketClass;
    }

    public void setTicketClass(TicketClass ticketClass) {
        this.ticketClass = ticketClass;
    }
}

