package models.people;
import models.infrastructure.Flight;
import models.infrastructure.Ticket;

import java.util.Objects;

public class Passenger extends Person {

    private Ticket ticket;
    private Integer baggageWeightKG;

    public Passenger() {};

    public Passenger(Long id,
                     String firstName,
                     String lastName,
                     Ticket ticket,
                     Integer baggageWeightKG) {
        super(id, firstName, lastName);
        this.ticket = ticket;
        this.baggageWeightKG = baggageWeightKG;
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
        Flight flight = ticket.getFlight();
        flight.addPassenger(this);
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
}