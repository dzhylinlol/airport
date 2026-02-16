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

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Flight flight = new Flight(13L);
        setAirports(flight);

        PassengerPlane passengerPlane = new PassengerPlane(7456L, "Boeing-4657", 20, 746);
        addCrewToPlane(passengerPlane);

        List<Passenger> passengers = createPassengers();
        List<Ticket> tickets = createTickets(flight.getId(), passengerPlane.getCapacity());

        Map<Long, Ticket> assignments = assignTicketsToPassengers(passengers, tickets);
        for (Map.Entry<Long, Ticket> entry : assignments.entrySet()) {
            System.out.println("Passenger ID: " + entry.getKey());
            System.out.println("Ticket: " + entry.getValue());
        }

        LinkedList<Passenger> passengersChecked = new LinkedList<>(passengers);
        checkCorona(passengersChecked);
        checkInPassengers(passengersChecked);

        System.out.println("Passengers who managed to get to the Plane > ");
        for (Passenger passenger : passengersChecked) {
            System.out.println(passenger + " " + passenger.getTicket());
        }

        passengerPlane.addPassengers(passengers);
        flight.setAirplane(passengerPlane);

        Weather weather = Weather.STORM;
        checkWeather(weather);

        Weather weather1 = Weather.SUNNY;
        checkWeather(weather1);

        checkOverWeight(passengerPlane);

        System.out.println("\n9. Flight processing...");
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
        System.out.println("\n3. Passengers gathering for the flight...");
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

    public static List<Ticket> createTickets(Long flightId, int ticketCount) {
        System.out.println("\n4. Tickets prepared based of passenger plane capacity...");

        List<Ticket> tickets = new ArrayList<>();
        Set<String> usedSeats = new HashSet<>();

        int seatNumber = 1;
        while (tickets.size() < ticketCount) {
            String seat = "A" + seatNumber;
            String number = "T" + seatNumber;
            seatNumber++;

            if (usedSeats.add(seat)) {
                Ticket ticket = new Ticket(number, flightId, seat);
                tickets.add(ticket);
            }
        }
        return tickets;
    }

    public static Map<Long, Ticket> assignTicketsToPassengers(List<Passenger> passengers, List<Ticket> tickets) {
        System.out.println("\n5. Passengers 'buy' tickets...");

        Map<Long, Ticket> passengerTickets = new HashMap<>();
        int i = 0;

        for (Passenger passenger : passengers) {
            if (i >= tickets.size()) {
                break;
            }
            Ticket ticket = tickets.get(i);
            passengerTickets.put(passenger.getId(), ticket);
            passenger.setTicket(ticket);
            i++;
        }
        return passengerTickets;
    }

    public static void checkCorona(Queue<Passenger> passengers) {
        System.out.println("\n6. Corona check...");

        SecurityAgent securityAgent = new SecurityAgent();
        int originalSize = passengers.size();

        for (int i = 0; i < originalSize; i++) {
            Passenger passenger = passengers.poll();
            try {
                securityAgent.checkForCorona(passenger);
                passengers.add(passenger);
            } catch (PersonHasCoronaVirusException e) {
                System.out.println(passenger + " is sick");
            }
        }
    }

    public static void checkInPassengers(List<Passenger> passengers) {
        System.out.println("\n7. Ticket check...");
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

    public static void checkOverWeight(PassengerPlane passengerPlane) {
        System.out.println("\n8. Overweight check...");

        if (BaggageUtility.hasOverWeight(passengerPlane)) {
            System.out.println("Flight baggage is OVER the limit!");
        } else {
            System.out.println("Flight baggage weight is OK");
        }
    }

    public static void checkWeather(Weather weather) {
        System.out.println("\n !Weather Check!...");

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


