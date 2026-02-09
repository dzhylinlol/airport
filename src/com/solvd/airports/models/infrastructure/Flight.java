package com.solvd.airports.models.infrastructure;

import com.solvd.airports.exceptions.PlaneIsBrokenExceptionException;
import com.solvd.airports.models.people.FlightAttendant;
import com.solvd.airports.models.people.Passenger;
import com.solvd.airports.models.people.Pilot;
import com.solvd.airports.models.planes.Airplane;

import java.util.ArrayList;
import java.util.List;

public class Flight {
    private Long id;
    private Gate gate;
    private Terminal terminal;
    private Airplane airplane;

    public Flight() {
    }

    public Flight(Long id){
        this.id = id;
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
                  Airplane airplane,

                  Terminal terminal) {
        this.id = id;
        this.gate = gate;

        this.terminal = terminal;
        this.airplane = airplane;
    }

    @Override
    public String toString() {
        return "Flight {" +
                "id='" + id + '\'' +
                ", terminal =" + terminal +
                ", gate='" + gate + '\'' +
                ", airplane='" + airplane + '\'' +
                '}';

    }

//    public void addPassenger(Passenger newPassenger) {
//        if (this.passengers == null) {
//            this.passengers = new ArrayList<>();
//            passengers.add(newPassenger);
//            return;
//        }
//
//        boolean hasSamePassenger = false;
//        for (Passenger oldPassenger : passengers) {
//            if (oldPassenger.equals(newPassenger)) {
//                hasSamePassenger = true;
//            }
//        }
//        if (hasSamePassenger == false) {
//            this.passengers.add(newPassenger);
//        }
//    }

//    public void addPassengers(List<Passenger> newPassengers) {
//        for (Passenger newOne : newPassengers) {
//            this.addPassenger(newOne);
//        }
//    }
//
//    public void addFlightAttendant(FlightAttendant flightAttendant) {
//        if (this.flightAttendants == null) {
//            this.flightAttendants = new ArrayList<>();
//        }
//        this.flightAttendants.add(flightAttendant);
//    }

    public void start() throws PlaneIsBrokenExceptionException {
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

}
