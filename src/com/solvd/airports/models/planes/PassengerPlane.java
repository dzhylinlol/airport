package com.solvd.airports.models.planes;

import com.solvd.airports.exceptions.PlaneIsBrokenExceptionException;
import com.solvd.airports.interfaces.IFly;

public class PassengerPlane extends Airplane implements IFly {

    private Integer capacity;
    private Integer baggageCapacityKg;

    public PassengerPlane() {
    }

    public PassengerPlane(Long id,
                          String model,
                          Boolean isBroken,
                          Integer capacity,
                          Integer baggageCapacityKg) {
        super(id, model,  isBroken);
        this.capacity = capacity;
        this.baggageCapacityKg = baggageCapacityKg;
    }

    ;

    @Override
    public String toString() {
        return " passenger plane {" +
                super.toString() + '}';

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
}
