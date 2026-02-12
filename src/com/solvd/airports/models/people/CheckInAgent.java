
package com.solvd.airports.models.people;

import com.solvd.airports.exceptions.PassengerHasNoTicketException;
import com.solvd.airports.models.planes.PassengerPlane;

import java.util.List;

public class CheckInAgent extends Person {
    private String airline;

    public CheckInAgent() {
    }

    public CheckInAgent(Long id,
                        String firstName,
                        String lastName,
                        String airline) {
        super(id, firstName, lastName);
        this.airline = airline;
    }

    @Override
    public String getRole() {
        return "Checking Agent" + getFirstName() + " " + getLastName() + "is responsible for passengers check-in";
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public void process(Passenger passenger) throws PassengerHasNoTicketException {
        if (passenger.getTicket() == null) {
            throw new PassengerHasNoTicketException("User does not have a ticket, can not proceed with security check");
        } else {
            passenger.getTicket().setSeatNumber("A2");
        }
    }

    // add try-catch
    public void process(List<Passenger> passengers) throws PassengerHasNoTicketException {
        for (Passenger passenger : passengers) {
            process(passenger);
        }
    }

}
