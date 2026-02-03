package services;

import models.infrastructure.*;
import models.people.FlightAttendant;
import models.people.Passenger;
import models.people.Pilot;
import models.planes.Airplane;
import models.planes.PassengerPlane;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("==========Flight Preparation==========");

        System.out.println("======1. Airports  creation: adding gates and terminals======");
        Airport airportFrom = new Airport("WAW", "Chopin");
        Airport airportTo = new Airport("MSQ", "Minsk National Airport");

        Terminal terminalFrom = new Terminal("A");
        Terminal terminalTo = new Terminal("B");
        airportFrom.addTerminal(terminalFrom);
        airportTo.addTerminal(terminalTo);

        Gate gateFrom = new Gate(6);
        Gate gateTo = new Gate(7);
        terminalFrom.addGate(gateFrom);
        terminalTo.addGate(gateTo);

        System.out.println("Airport from: " + airportFrom);
        System.out.println("Airport to: " + airportTo);

        System.out.println("======2.Adding crew,  passenger plane, composing flight=====");

        Pilot pilot = new Pilot(1L, "Mike", "White","pilot84574", 24, "KL35", "1st");
        FlightAttendant flightAttendant = new FlightAttendant(298L, "Sarah", "Black", "fa18373", 12, List.of("English", "Polish", "Russian"), true);
        Airplane passengerPlane = new PassengerPlane(7456L,"HGG-4657",746,65333);
        Flight flight = new Flight("WM9875",gateFrom, pilot, passengerPlane, flightAttendant, new ArrayList<>(), terminalFrom);


        Ticket ticket1 = new Ticket("T1","WM9875", "14B", null);
        Ticket ticket2 = new Ticket("T2","WM9875", "14C", null);
        Ticket ticket3 = new Ticket("T3","WM9875", "14G", null);
        Ticket ticket4 = new Ticket("T4","WM9875", "14H", null);

        ticket4.bookedBy(5L, "Maria", "Petrovna");
        System.out.println("Ticket 4: " + ticket4);

        Passenger passenger1 = new Passenger(876L, "Adam", "Lipski", ticket1.getNumber());
        Passenger passenger1copy = new Passenger(878L, "Adam", "Lipski", ticket1.getNumber());
        Passenger passenger2 = new Passenger(93L, "Denis", "Mckean", ticket3.getNumber());

        ticket3.bookedBy(passenger1);
        System.out.println("Ticket 3: " + ticket3 + " " + passenger1);

        System.out.println("Ticket" + ticket1.toString());
        System.out.println(passenger1.toString());

        passenger1.buyTicket(ticket1);
        passenger2.buyTicket(ticket2);

        flight.addPassenger(passenger1);
        flight.addPassenger(passenger1copy);
        flight.addPassenger(passenger2);

        System.out.println("Airplane is prepared: " + flight);

        System.out.println(flight.getPassengers());

        System.out.println("Added Users = " + flight.getPassengers().toString());

        System.out.println("Ticket" + ticket1.toString());
        System.out.println("Passenger " + passenger1.toString());

        flight.start();

        flight.finish();



    }
}
