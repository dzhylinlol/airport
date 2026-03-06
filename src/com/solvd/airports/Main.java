package com.solvd.airports;

import com.solvd.airports.exceptions.*;
import com.solvd.airports.models.planes.Weather;
import com.solvd.airports.models.infrastructure.*;
import com.solvd.airports.models.people.*;
import com.solvd.airports.models.planes.PassengerPlane;
import com.solvd.airports.services.DLinkedList;
import com.solvd.airports.utilities.BaggageUtility;

import java.time.LocalDateTime;
import java.util.*;

import java.util.stream.IntStream;

import static com.solvd.airports.models.people.PassengerPriority.*;

public class Main {

    public static void main(String[] args) {
        Flight flight = new Flight(13L);
        setAirports(flight);

        checkArrivalAirportContactInfo();

        PassengerPlane passengerPlane = new PassengerPlane(7456L, "Boeing-4657", 20, 1000);
        addCrewToPlane(passengerPlane);

        LinkedList<Passenger> passengers = createPassengers();
        List<Ticket> tickets = createTickets(flight.getId(), passengerPlane.getCapacity());

        Map<Passenger, Ticket> assignments = assignTicketsToPassengers(passengers, tickets);
        assignments.entrySet()
                   .stream()
                   .forEach(entry ->
                           System.out.println(
                                   entry.getKey().getFirstName() + " "
                                           + entry.getKey().getLastName()
                                           + " -> Ticket: "
                                           + entry.getValue().getNumber()
                           )
                   );

        checkLoungeAccess(passengers);

        checkInPassengers(passengers);
        checkCorona(passengers);


        System.out.println("\nPassengers who managed to get to the Plane after health/ticket screening> ");
        passengers.stream()
                  .forEach(passenger -> System.out.println(passenger + " " + passenger.getTicket()));

        passengerPlane.addPassengers(passengers);
        flight.setAirplane(passengerPlane);

        System.out.println("\n9. Flight processing...");

        boolean readyToFly = false;
        Weather weather = Weather.STORM;
        Meteorologist meteorologist = new Meteorologist();
        passengerPlane.setIsBroken(true);

        while (!readyToFly) {
            try {
                meteorologist.checkWeather(weather);
                BaggageUtility.checkOverWeight(passengerPlane);
                passengerPlane.checkIsBroken();
                readyToFly = true;
            } catch (BadWeatherException e) {
                System.out.println(e.getMessage());
                System.out.println("Waiting for good weather");
                weather = Weather.SUNNY;
                System.out.println("The weather is " + weather.name());
            } catch (BaggageOverweightException e) {
                System.out.println(e.getMessage());
                passengers.getFirst().setBaggageWeightKG(5);
                System.out.println("Overweight Fixed...");
            } catch (PlaneIsBrokenExceptionException e) {
                System.out.println(e.getMessage());
                System.out.println("Waiting for the plane to be fixed!");
                passengerPlane.setIsBroken(false);
                System.out.println("The plane is good to go!");
            }
        }

        flight.start();
        flight.finish();

        System.out.println("\n10. Custom Linked List...");
        DLinkedList<Passenger> list = new DLinkedList<>();
        playWithLL(list);

    }

    public static void setAirports(Flight flight) {
        System.out.println("\n1. Flight is scheduled: Route...");

        Terminal terminalFrom = new Terminal("A");
        Terminal terminalTo = new Terminal("B");
        Airport chopin = new Airport("WAW", "Chopin", List.of(terminalFrom));
        Airport msq = new Airport("MSQ", "Minsk National Airport", List.of(terminalTo));

        flight.setAirportFrom(chopin);
        flight.setAirportTo(msq);

        FlightRoute route = new FlightRoute(
                chopin,
                msq,
                LocalDateTime.of(2026, 3, 1, 14, 20),
                LocalDateTime.of(2026, 3, 1, 16, 50));

        System.out.println("Flight - " + flight.getId() + "scheduled from " + chopin + " to " + msq);
        System.out.println("Duration (minutes): " + route.getFlightDurationInMinutes());
    }

    public static void checkArrivalAirportContactInfo() {
        AirportContactInfo contactMSQ = new AirportContactInfo("MSQ", "+375 17 279-13-00", "msqtkt@transavia.by", "https://airport.by");
        System.out.println("Arrival Airport Contact Info - " + contactMSQ);
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

    public static LinkedList<Passenger> createPassengers() {
        System.out.println("\n3. Passengers gathering for the flight...");
        LinkedList<Passenger> passengers = new LinkedList<>();

        Passenger passenger1 = new Passenger(1L, "Adam", "Lipski", 1, false, GOLD);
        Passenger passenger2 = new Passenger(2L, "Ewa", "Polska", 20, true, STANDARD);
        Passenger passenger3 = new Passenger(3L, "Piotr", "Zapolski", 5, false, VIP);
        Passenger passenger4 = new Passenger(4L, "Anna", "Mitskewich", 10, false, PLATINUM);
        Passenger passenger5 = new Passenger(5L, "Darya", "Zhylinskaya", 8, true, VIP);
        Passenger passenger6 = new Passenger(6L, "Julia", "Miller", 10, false, GOLD);
        Passenger passenger7 = new Passenger(7L, "Julia", "Miller", 10, true, STANDARD);

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

        IntStream.rangeClosed(1, ticketCount)
                 .forEach(i -> tickets.add(new Ticket("T" + i, flightId, "A" + i)));

        return tickets;
    }

    public static Map<Passenger, Ticket> assignTicketsToPassengers(Queue<Passenger> passengers, List<Ticket> tickets) {
        System.out.println("\n5. Passengers 'buy' tickets...");

        Map<Passenger, Ticket> passengerTickets = new HashMap<>();
        int i = 0;

        for (Passenger passenger : passengers) {
            if (i >= tickets.size()) {
                break;
            }
            Ticket ticket = tickets.get(i);
            passengerTickets.put(passenger, ticket);
            passenger.setTicket(ticket);
            i++;
        }
        return passengerTickets;
    }

    public static void checkLoungeAccess(Queue<Passenger> passengers) {
        System.out.println("\nPassengers with lounge access:");

        passengers.stream()
                  .filter(passenger -> passenger.getPriority().hasLoungeAccess())
                  .forEach(System.out::println);
    }

    public static void checkInPassengers(LinkedList<Passenger> passengers) {
        System.out.println("\n7. Ticket verification...");
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

    public static void checkCorona(Queue<Passenger> passengers) {
        System.out.println("\n6. Corona check...");

        SecurityAgent securityAgent = new SecurityAgent();
        int originalSize = passengers.size();

        for (int i = 0; i < originalSize; i++) {
            Passenger passenger = passengers.poll();
            try {
                securityAgent.process(passenger);
                passengers.add(passenger);
            } catch (PersonHasCoronaVirusException e) {
                System.out.println(passenger + " is sick");
            }
        }
    }

    public static void playWithLL(DLinkedList<Passenger> list) {
        Passenger passenger1 = new Passenger(11L, "Bob", "Mem", 20, false, GOLD);
        Passenger passenger2 = new Passenger(12L, "Mike", "Kek", 55, false, VIP);
        Passenger passenger3 = new Passenger(13L, "Luc", "Lol", 12, false, PLATINUM);
        Passenger passenger4 = new Passenger(14L, "Rick", "Son", 5, false, STANDARD);

        list.addToTail(passenger1);
        list.addToTail(passenger2);
        list.addToTail(passenger3);
        list.addToTail(passenger4);

        list.print();

        list.removeFromTail();

        list.print();

        System.out.println(list.getItem(2));

    }

}
