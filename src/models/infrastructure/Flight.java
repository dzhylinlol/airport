package models.infrastructure;
import models.people.FlightAttendant;
import models.people.Passenger;
import models.people.Pilot;
import models.planes.Airplane;

import java.util.List;

public class Flight {
    private String id;
    private Gate gate;
    private Pilot pilot;
    private Terminal terminal;
    private Airplane airplane;
    private List<Passenger> passengers;
    private FlightAttendant flightAttendant;

    public Flight() {}

    public Flight(String id,
                  Gate gate,
                  Pilot pilot,
                  Airplane airplane,
                  FlightAttendant flightAttendant,
                  List<Passenger> passengers,
                  Terminal terminal) {
        this.id = id;
        this.gate = gate;
        this.pilot = pilot;
        this.terminal = terminal;
        this.airplane = airplane;
        this.passengers = passengers;
        this.flightAttendant = flightAttendant;
    }

    public void start() {
        System.out.println("Starting Flight"); // запизнуть флайт наймре
        airplane.takeOff();
    };

    public void finish() {
        System.out.println("Finishing Flight");
        airplane.land();
    };

    public void addPassenger(Passenger newPassenger) {
        boolean hasSamePassenger = false;
        for (Passenger oldPassenger : passengers) {
            if (oldPassenger.equals(newPassenger)) {
                hasSamePassenger = true;
            }
        }
         if (hasSamePassenger == false){
             this.passengers.add(newPassenger);
         }
    }


    public String getId() {
        return id;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public Pilot getPilot() {
        return pilot;
    }
    public Gate getGate() {
        return gate;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public FlightAttendant getFlightAttendant() {
        return flightAttendant;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

}
