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
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Passenger passenger = (Passenger) o;

        if (this.hashCode() != passenger.hashCode()) return false;
        return Objects.equals(ticketNumber, passenger.ticketNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ticketNumber);
    }

    public void buyTicket(Ticket ticket) {
        this.ticketNumber = ticket.getNumber();
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

}