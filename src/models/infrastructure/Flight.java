package models.infrastructure;

import models.people.FlightAttendant;
import models.people.Passenger;
import models.people.Pilot;
import models.planes.Airplane;

import java.util.ArrayList;
import java.util.List;

public class Flight {
    private Long id;
    private Gate gate;
    private Pilot pilot;
    private Terminal terminal;
    private Airplane airplane;
    private List<Passenger> passengers;
    private List<FlightAttendant> flightAttendants;

    public Flight() {
    }

    public Flight(Long id,
                  Terminal terminal,
                  Gate gate) {
        this.id = id;
        this.gate = gate;
        this.terminal = terminal;
    }

    public Flight(Long id,
                  Gate gate,
                  Pilot pilot,
                  Airplane airplane,
                  List<FlightAttendant> flightAttendants,
                  List<Passenger> passengers,
                  Terminal terminal) {
        this.id = id;
        this.gate = gate;
        this.pilot = pilot;
        this.terminal = terminal;
        this.airplane = airplane;
        this.passengers = passengers;
        this.flightAttendants = flightAttendants;
    }

    @Override
    public String toString() {
        return "Flight {" +
                "id='" + id + '\'' +
                ", terminal =" + terminal +
                ", gate='" + gate + '\'' +
                ", airplane='" + airplane + '\'' +
                ", pilot=" + pilot +
                ", flight attendant=" + flightAttendants +
                ", passengers=" + passengers +
                '}';

    }

    public void addPassenger(Passenger newPassenger) {
        if (this.passengers == null) {
            this.passengers = new ArrayList<>();
            passengers.add(newPassenger);
            return;
        }

        boolean hasSamePassenger = false;
        for (Passenger oldPassenger : passengers) {
            if (oldPassenger.equals(newPassenger)) {
                hasSamePassenger = true;
            }
        }
        if (hasSamePassenger == false) {
            this.passengers.add(newPassenger);
        }
    }

    public void addPassengers(List<Passenger> newPassengers) {
        for (Passenger newOne : newPassengers) {
            this.addPassenger(newOne);
        }
    }

    public void addFlightAttendant(FlightAttendant flightAttendant) {
        if (this.flightAttendants == null) {
            this.flightAttendants = new ArrayList<>();
        }
        this.flightAttendants.add(flightAttendant);
    }

    public void start() {
        System.out.println("Starting Flight...");
        airplane.takeOff();
    };

    public void finish() {
        airplane.land();
        System.out.println("Finishing Flight...");
    };

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

    public List<FlightAttendant> getFlightAttendants() {
        return flightAttendants;
    }

    public void setFLightAttendants(List<FlightAttendant> flightAttendants) {
        this.flightAttendants = flightAttendants;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

}
