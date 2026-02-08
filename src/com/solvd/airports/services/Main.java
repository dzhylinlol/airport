package com.solvd.airports.services;

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
    public static void main(String[] args)  {
        System.out.println("\n1. Airports  creation: adding gates and terminals");
        Airport airportFrom = new Airport("WAW", "Chopin");
        Airport airportTo = new Airport("MSQ", "Minsk National Airport");
        Airplane passengerPlane = new PassengerPlane(7456L, "HGG-4657", false, 65333, 746);

        Terminal terminalFrom = new Terminal("A");
        Gate gateFrom = new Gate(6);
        terminalFrom.addGate(gateFrom);
        airportFrom.addTerminal(terminalFrom);

        Terminal terminalTo = new Terminal("B");
        Gate gateTo = new Gate(7);
        terminalTo.addGate(gateTo);
        airportTo.addTerminal(terminalTo);

        System.out.println("Airports: FROM " + airportFrom + " TO " + airportTo);

        System.out.println("\n2.Adding crew");

        Pilot pilot = new Pilot(1L, "Mike", "White", "pilot84574", 24, "KL35", "1st");
        FlightAttendant attendant1 = new FlightAttendant(298L, "Zanna", "Black", "fa18373", 12, List.of("English", "Polish", "Russian"), true);
        FlightAttendant attendant2 = new FlightAttendant(298L, "Anna", "Black", "fa18373", 12, List.of("English", "Polish", "Russian"), true);

        System.out.println("pilot: " + pilot + "\nattendatnts: \n" + attendant1 + "\n" + attendant2);

        System.out.println("\n3.Creating flight");

        Flight flight = new Flight(87L, terminalFrom, gateFrom);
        flight.setAirplane(passengerPlane);
        flight.setPilot(pilot);
        flight.addFlightAttendant(attendant1);
        flight.addFlightAttendant(attendant2);

        System.out.println("Flight created: " + flight);

        System.out.println("\n4.Issuing Tickets: ");

        Ticket ticket1 = new Ticket("T1", flight, "14B");
        Passenger passenger1 = new Passenger(1L, "Adam", "Lipski", 25);
        passenger1.buyTicket(ticket1);

        Ticket ticket2 = new Ticket("T2", flight, "14C");
        Passenger passenger2 = new Passenger(2L, "Ewa", "Polska", 20);
        passenger2.buyTicket(ticket2);

        Ticket ticket3 = new Ticket("T3", flight, "14G");
        Passenger passenger3 = new Passenger(3L, "Piotr", "Zapolski", 5);
        passenger3.buyTicket(ticket3);

        Ticket ticket4 = new Ticket("T4", flight, "14H");
        Passenger passenger4 = new Passenger(4L, "Anna", "Mitskewich", 10);
        Passenger passenger4copy = new Passenger(4L, "Anna", "Mitskewich", 10);
        passenger4.buyTicket(ticket4);
//        passenger4copy.buyTicket(ticket4);// adding same passenger
//        flight.addPassenger(passenger4copy);

        System.out.println("Flight filled: " + flight.getPassengers());

        System.out.println("\n5.Checking overweight:");

        if (BaggageUtility.hasOverWeight(flight)) {
            System.out.println("Flight baggage is OVER the limit!");
        } else {
            System.out.println("Flight baggage weight is OK");
        }

        System.out.println("\n6.Flight processing");
        try {
            flight.start();
            IPerformDuty captain = new Pilot(99L, "Jack", "Vorobey", "captainkdwef", 33, "LKi66", "1st"); //
            captain.performDuty(flight); // playing with interface

            IPerformDuty flightAttendant1 = new FlightAttendant(29L, "Olga", "Bliss", "captainkdef", 3, List.of("English", "Polish", "Russian"), true); //
            flightAttendant1.performDuty(flight);

            flight.finish();

            System.out.println("Flight processed");

        } catch (PlaneIsBrokenExceptionException e) {
            System.out.println("Airplane is broken! We can not strt flight");
        }

        System.out.println("\nStart cargo flight:");
        IFly airplane11 = new CargoPlane(88L, "fly123", 1230, 345.5);
//        airplane11.takeOff();
    }
}
