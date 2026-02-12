package com.solvd.airports.models.people;

import com.solvd.airports.models.infrastructure.Ticket;

public class Passenger extends Person {

    private Ticket ticket;
    private Integer baggageWeightKG;
    private boolean hasCorona = false;

    public Passenger() {
    }

    public Passenger(Long id,
                     String firstName,
                     String lastName,
                     Ticket ticket,
                     Integer baggageWeightKG,
                     boolean hasCorona) {
        super(id, firstName, lastName);
        this.ticket = ticket;
        this.baggageWeightKG = baggageWeightKG;
    }

    public Passenger(Long id,
                     String firstName,
                     String lastName,
                     Integer baggageWeightKG,
                     boolean hasCorona) {
        super(id, firstName, lastName);
        this.baggageWeightKG = baggageWeightKG;
        this.hasCorona = hasCorona;
    }

    public Passenger(Long id,
                     String firstName,
                     String lastName,
                     Integer baggageWeightKG) {
        super(id, firstName, lastName);
        this.baggageWeightKG = baggageWeightKG;
    }

    @Override
    public String getRole() {
        return "Passenger";
    }

    @Override
    public String toString() {
        return "Passenger: " + super.getFirstName() + " " + super.getLastName() + " "
                + (ticket == null ? "without ticket" : ticket.getNumber());
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Integer getBaggageWeightKG() {
        return baggageWeightKG;
    }

    public void setBaggageWeightKG(Integer baggageWeightKG) {
        this.baggageWeightKG = baggageWeightKG;
    }

    public boolean getHasCorona() {
        return hasCorona;
    }
    public void setHasCorona(boolean hasCorona) {
        this.hasCorona = hasCorona;
    }

}