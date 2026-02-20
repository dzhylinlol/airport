package com.solvd.airports.models.planes;

import com.solvd.airports.exceptions.PlaneIsBrokenExceptionException;
import com.solvd.airports.interfaces.IFly;
import com.solvd.airports.models.people.FlightAttendant;
import com.solvd.airports.models.people.Passenger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PassengerPlane extends Airplane<Passenger> implements IFly {

    private Integer capacity;
    private Integer baggageCapacityKg;
    private List<FlightAttendant> flightAttendants;

    public PassengerPlane() {
    }

    public PassengerPlane(Long id,
                          String model,
                          Integer capacity,
                          Integer baggageCapacityKg) {
        super(id, model);
        this.capacity = capacity;
        this.baggageCapacityKg = baggageCapacityKg;
    }

    @Override
    public void takeOff() throws PlaneIsBrokenExceptionException {
        if (this.getIsBroken()) {
            throw new PlaneIsBrokenExceptionException("Passenger plane is broken, can not be in use!");
        }
        System.out.println("Passenger plane " + super.getModel() + " starting engines");
    }

    @Override
    public void land() {
        System.out.println("Passenger plane " + super.getModel() + " landing");
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getBaggageCapacityKg() {
        return baggageCapacityKg;
    }

    public void setBaggageCapacityKg(Integer baggageCapacityKg) {
        this.baggageCapacityKg = baggageCapacityKg;
    }

    public List<FlightAttendant> getFlightAttendants() {
        return flightAttendants;
    }

    public void setFlightAttendants(List<FlightAttendant> flightAttendants) {
        this.flightAttendants = flightAttendants;
    }

    public List<Passenger> getPassengers() {
        return getLoad();
    }

    public void setPassengers(List<Passenger> passengers) {
        setLoad(passengers);
    }

    public void addPassenger(Passenger newPassenger) {
        List<Passenger> load = getLoad();
        if (load == null) {
            load = new ArrayList<>();
            load.add(newPassenger);
            super.setLoad(load);
            return;
        }

        boolean hasSamePassenger = false;
        for (Passenger oldPassenger : load) {
            if (oldPassenger.equals(newPassenger)) {
                hasSamePassenger = true;
            }
        }

        if (!hasSamePassenger) {
            load.add(newPassenger);
        }
    }

    public void addPassengers(Collection<Passenger> newPassengers) {
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


    @Override
    public String toString() {
        return "Passenger plane: " +
                super.toString() + "\nPilot: " + getPilot() + "\nAttendants: " + flightAttendants;
    }

}


