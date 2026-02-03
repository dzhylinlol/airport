package models.people;

import models.infrastructure.Ticket;

import java.util.Objects;

public class Passenger extends Person {

    private String ticketNumber;

    public Passenger() {};

    public Passenger(Long id,
                     String firstName,
                     String lastName,
                     String ticketNumber) {
        super(id, firstName, lastName);
        this.ticketNumber = ticketNumber;
    }

    @Override
    public String getRole() {
        return "Passenger";
    }

    @Override
    public String toString() {
        return "Passenger: " + super.getFirstName() + " " + super.getLastName() + " " + ticketNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (this.getClass() != o.getClass()) return false;
        Passenger that = (Passenger) o;
        if (super.getId().equals(that.getId())) return true;
        return false;
    }

    @Override
    public int hashCode() {
        return super.getId().hashCode();
    }

    public void buyTicket(Ticket ticket) {
        this.ticketNumber = ticket.getNumber();
        ticket.addPassenger(this);
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

}