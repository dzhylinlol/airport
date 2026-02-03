package models.people;
import models.infrastructure.Ticket;

import java.util.Objects;

public class Passenger extends Person {
    private Ticket ticket;

    public Passenger() {};

    public Passenger(Long id,
                     String firstName,
                     String lastName,
                     Ticket ticket) {
        super(id, firstName, lastName);
        this.ticket = ticket;
    }

    @Override
    public String getRole() {
        return "Passenger";
    }

    @Override
    public String toString() {
        return "Passenger: " + super.getFirstName() + " " + super.getLastName() + " " + ticket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Passenger passenger = (Passenger) o;

        if (this.hashCode() != passenger.hashCode()) return false;
        return Objects.equals(ticket, passenger.ticket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ticket);
    }

    public void buyTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

}