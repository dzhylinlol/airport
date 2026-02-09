package com.solvd.airports.services;

import com.solvd.airports.exceptions.PersonHasCoronaVirusException;
import com.solvd.airports.exceptions.PlaneIsBrokenExceptionException;
import com.solvd.airports.interfaces.IFly;
import com.solvd.airports.interfaces.IPerformDuty;
import com.solvd.airports.models.infrastructure.*;
import com.solvd.airports.models.people.FlightAttendant;
import com.solvd.airports.models.people.Passenger;
import com.solvd.airports.models.people.Pilot;
import com.solvd.airports.models.planes.Airplane;
import com.solvd.airports.models.planes.CargoPlane;
import com.solvd.airports.models.planes.PassengerPlane;
import com.solvd.airports.models.utilities.BaggageUtility;

import java.util.List;

public class Main {
    public static void main(String[] args) throws PersonHasCoronaVirusException {
        System.out.println("\n1. Flight is scheduled: Route...");
        Airport airportFrom = new Airport("WAW", "Chopin");
        Airport airportTo = new Airport("MSQ", "Minsk National Airport");
        Flight flight = new Flight(13L);
        System.out.println("Airports: FROM " + airportFrom + " TO " + airportTo);


        System.out.println("\n2. Crew assigned to the Airplane...");
        PassengerPlane passengerPlane = new PassengerPlane(7456L, "Boeing-4657", 20, 746);
        Pilot pilot = new Pilot(1L, "Mike", "White", "pilot84574", 24, "KL35", "1st");
        FlightAttendant attendant1 = new FlightAttendant(298L, "Zanna", "Black", "fa18373", 12, List.of("English", "Polish", "Russian"), true);
        FlightAttendant attendant2 = new FlightAttendant(298L, "Anna", "Black", "fa18373", 12, List.of("English", "Polish", "Russian"), false);
        passengerPlane.setPilot(pilot);
        passengerPlane.setFlightAttendants(List.of(attendant1, attendant2));

        System.out.println("Airplane: " + passengerPlane);

        System.out.println("\n3. Terminal and Gate Assignment to the Flight... ");
        Terminal terminalFrom = new Terminal("A");
        Gate gateFrom = new Gate(6);
        terminalFrom.addGate(gateFrom);

        flight.setTerminal(terminalFrom);
        flight.setGate(terminalFrom.getGates().getFirst());

        System.out.println("Flight is assigned with " + flight.getTerminal()  + " to start from...");

        System.out.println("\n4. Airplane is assigned to the FLight, Boarding starts...");
        flight.setAirplane(passengerPlane);

        Ticket ticket1 = new Ticket("T1", flight.getId(), "14B");
        Passenger passenger1 = new Passenger(1L, "Adam", "Lipski", 25);
        passenger1.setTicket(ticket1);

        Ticket ticket2 = new Ticket("T2", flight.getId(), "14C");
        Passenger passenger2 = new Passenger(2L, "Ewa", "Polska", 20);
        passenger2.setTicket(ticket2);

        Ticket ticket3 = new Ticket("T3", flight.getId(), "14G");
        Passenger passenger3 = new Passenger(3L, "Piotr", "Zapolski", 5);
        passenger3.setTicket(ticket3);

        Ticket ticket4 = new Ticket("T4", flight.getId(), "14H");
        Passenger passenger4 = new Passenger(4L, "Anna", "Mitskewich", 10);
        passenger4.setTicket(ticket4);

        passengerPlane.addPassengers(List.of(passenger1, passenger2, passenger3, passenger4));

        System.out.println("Airplane boarded with passengers: " + passengerPlane.getPassengers());

        System.out.println("\n5. Checking overweight:");

        if (BaggageUtility.hasOverWeight(passengerPlane)) {
            System.out.println("Flight baggage is OVER the limit!");
        } else {
            System.out.println("Flight baggage weight is OK");
        }

        System.out.println("\n6. Flight processing...");
        try {
            flight.start();

            flight.finish();

            System.out.println("Flight processed...");

        } catch (PlaneIsBrokenExceptionException e) {
            System.out.println("Airplane is broken! We can not strt flight");
        }

        System.out.println("\nStart cargo flight:");
        IFly airplane11 = new CargoPlane(88L, "fly123", 1230, 345.5);
//        airplane11.takeOff();
    }
} //System.out.println("Flight created: " + flight);
