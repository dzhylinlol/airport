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

    @Override
    public String toString() {
        return "Flight {" +
                "id='" + id + '\'' +
                ", terminal =" + terminal +
                ", gate='" + gate + '\'' +
                ", airplane='" + airplane + '\'' +
                ", pilot=" + pilot +
                ", flight attendant=" + flightAttendant +
                ", passengers=" + passengers.size() +
                '}';

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

    public void setId(String id) {
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

    public  void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

    public FlightAttendant getFlightAttendant() {
        return flightAttendant;
    }

    public void setFLightAttendant(FlightAttendant flightAttendant) {
        this.flightAttendant = flightAttendant;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

}
