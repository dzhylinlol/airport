package models.planes;

public class CargoPlane extends Airplane {
    private Integer maxPayloadKg;
    private Double cargoVolumeCubicMeters;

    public CargoPlane() {}

    public CargoPlane(Long id,
                      String model,
                      Integer maxPayloadKg,
                      Double currentPayloadKg) {
        super(id, model);
        this.maxPayloadKg = maxPayloadKg;
        this.cargoVolumeCubicMeters = currentPayloadKg;
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
    public Double getCargoVolumeCubicMeters() {
        return cargoVolumeCubicMeters;
    }
    public void setCargoVolumeCubicMeters(Double cargoVolumeCubicMeters) {
        this.cargoVolumeCubicMeters = cargoVolumeCubicMeters;
    }
}
