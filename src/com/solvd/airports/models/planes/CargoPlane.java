package com.solvd.airports.models.planes;

public class CargoPlane extends Airplane {

    private Integer maxPayloadKg;
    private Double volumeCubicMeters;

    public CargoPlane() {
    }

    public CargoPlane(Long id,
                      String model,
                      Integer maxPayloadKg,
                      Double currentPayloadKg) {
        super(id, model);
        this.maxPayloadKg = maxPayloadKg;
        this.volumeCubicMeters = currentPayloadKg;
    }

    @Override
    public void takeOff() {
        System.out.println("Cargo plane " + super.getModel() + " starting engines");
    }

    @Override
    public void land() {
        System.out.println("Cargo plane " + super.getModel() + " landing");
    }

    public Integer getMaxPayloadKg() {
        return maxPayloadKg;
    }

    public void setMaxPayloadKg(Integer maxPayloadKg) {
        this.maxPayloadKg = maxPayloadKg;
    }

    public Double getVolumeCubicMeters() {
        return volumeCubicMeters;
    }

    public void setVolumeCubicMeters(Double volumeCubicMeters) {
        this.volumeCubicMeters = volumeCubicMeters;
    }
}
