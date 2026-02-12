package com.solvd.airports;

import com.solvd.airports.exceptions.BadWeatherException;
import com.solvd.airports.exceptions.PassengerHasNoTicketException;
import com.solvd.airports.exceptions.PersonHasCoronaVirusException;
import com.solvd.airports.exceptions.PlaneIsBrokenExceptionException;
import com.solvd.airports.models.Weather;
import com.solvd.airports.models.infrastructure.*;
import com.solvd.airports.models.people.*;
import com.solvd.airports.models.planes.PassengerPlane;
import com.solvd.airports.utilities.BaggageUtility;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Flight flight = new Flight(13L);
        setAirports(flight);

        PassengerPlane passengerPlane = new PassengerPlane(7456L, "Boeing-4657", 20, 746);
        addCrewToPlane(passengerPlane);

        List<Passenger> passengers = createPassengers();
        List<Ticket> tickets = createTickets(flight);

        assignTicketsToPassengers(passengers, tickets);

        checkCorona(passengers);
        checkInPassengers(passengers);

        System.out.println("Passengers who managed to get to the Plane = " + passengers);

        passengerPlane.addPassengers(passengers);
        flight.setAirplane(passengerPlane);

        Weather weather = Weather.STORM;
        checkWeather(weather);

        Weather weather1 = Weather.SUNNY;
        checkWeather(weather1);

        // check baggage

        System.out.println("\n6. Flight processing...");
        try {
            flight.start();
        } catch (PlaneIsBrokenExceptionException e) {
            throw new RuntimeException(e); // catch не выбрасывается в мейне
        }
        flight.finish();
        System.out.println("Flight processed...");

    }

    public static void setAirports(Flight flight) {
        System.out.println("\n1. Flight is scheduled: Route...");

        Terminal terminalFrom = new Terminal("A");
        Terminal terminalTo = new Terminal("B");
        Airport airportFrom = new Airport("WAW", "Chopin", List.of(terminalFrom));
        Airport airportTo = new Airport("MSQ", "Minsk National Airport", List.of(terminalTo));

        flight.setAirportFrom(airportFrom);
        flight.setAirportTo(airportTo);

        System.out.println("Flight - " + flight.getId() + "scheduled from " + airportFrom + " to " + airportTo);
    }

    public static void addCrewToPlane(PassengerPlane passengerPlane) {
        System.out.println("\n2. Crew assigned to the Airplane...");

        Pilot pilot = new Pilot(1L, "Mike", "White", "pilot84574", 24, "KL35", "1st");

        FlightAttendant attendant1 = new FlightAttendant(298L, "Zanna", "Black", "fa18373", 12, List.of("English", "Polish", "Russian"), true);
        FlightAttendant attendant2 = new FlightAttendant(298L, "Anna", "Black", "fa18373", 12, List.of("English", "Polish", "Russian"), false);

        passengerPlane.setPilot(pilot);
        passengerPlane.setFlightAttendants(List.of(attendant1, attendant2));

        System.out.println("Airplane: " + passengerPlane);
    }

    public static List<Passenger> createPassengers() {
        List<Passenger> passengers = new ArrayList<>();

        Passenger passenger1 = new Passenger(1L, "Adam", "Lipski", 25, false);
        Passenger passenger2 = new Passenger(2L, "Ewa", "Polska", 20, true);
        Passenger passenger3 = new Passenger(3L, "Piotr", "Zapolski", 5, false);
        Passenger passenger4 = new Passenger(4L, "Anna", "Mitskewich", 10, false);
        Passenger passenger5 = new Passenger(5L, "Darya", "Zhylinskaya", 8, true);
        Passenger passenger6 = new Passenger(6L, "Julia", "Miller", 10, false);
        Passenger passenger7 = new Passenger(7L, "Julia", "Miller", 10, true);

        passengers.add(passenger1);
        passengers.add(passenger2);
        passengers.add(passenger3);
        passengers.add(passenger4);
        passengers.add(passenger5);
        passengers.add(passenger6);
        passengers.add(passenger7);

        return passengers;
    }

    public static List<Ticket> createTickets(Flight flight) {
        Ticket ticket1 = new Ticket("T1", flight.getId(), "14B");
        Ticket ticket2 = new Ticket("T2", flight.getId(), "14C");
        Ticket ticket3 = new Ticket("T3", flight.getId(), "14G");
        Ticket ticket4 = new Ticket("T4", flight.getId(), "14H");
        Ticket ticket5 = new Ticket("T5", flight.getId(), "14I");
        return List.of(ticket1, ticket2, ticket3, ticket4, ticket5);

    }

    public static void assignTicketsToPassengers(List<Passenger> passengers, List<Ticket> tickets) {
        int limit = Math.min(passengers.size(), tickets.size());
        for (int i = 0; i < limit; i = i + 1) {
            passengers.get(i).setTicket(tickets.get(i));
        }
    }

    public static void checkCorona(List<Passenger> passengers) {
        SecurityAgent securityAgent = new SecurityAgent();
        for (int i = 0; i < passengers.size(); i++) {
            Passenger passenger = passengers.get(i);
            try {
                securityAgent.checkForCorona(passenger);
            } catch (PersonHasCoronaVirusException e) {
                passengers.remove(i);
                i--;
            }
        }
    }

    public static void checkInPassengers(List<Passenger> passengers) {
        CheckInAgent checkInAgent = new CheckInAgent();
        for (int i = 0; i < passengers.size(); i++) {
            Passenger passenger = passengers.get(i);
            try {
                checkInAgent.process(passenger);
            } catch (PassengerHasNoTicketException e) {
                passengers.remove(i);
                i--;
            }
        }
    }

    public static void checkWeather(Weather weather) {
        try {
            if (!weather.isFlyable()) {
                throw new BadWeatherException(
                        "We can't start the flight. We need to wait for better weather."
                );
            }

            System.out.println("We can start the flight.");

        } catch (BadWeatherException e) {
            System.out.println(e.getMessage());
        }
    }
}

public void departureGatesAssigned(Flight flight) {
    Gate gateFrom = new Gate(4);
    flight.getAirportFrom()
            .getTerminals()
            .getFirst()
            .addGate(gateFrom);
    System.out.println("Flight is assigned with " + flight.getAirportFrom().getTerminals() + " to start from...");
}

public static void checkOverWeight(PassengerPlane passengerPlane) {
    if (BaggageUtility.hasOverWeight(passengerPlane)) {
        System.out.println("Flight baggage is OVER the limit!");
    } else {
        System.out.println("Flight baggage weight is OK");
    }
}
