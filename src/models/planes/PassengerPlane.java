package models.planes;

import interfaces.IFly;
import models.infrastructure.Flight;

public class PassengerPlane extends Airplane implements IFly {

    private Integer capacity;
    private Integer baggageCapacityKg;

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

    ;

    @Override
    public String toString() {
        return " passenger plane {" +
                super.toString() + '}';

    }

    @Override
    public void takeOff() {
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
