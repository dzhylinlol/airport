package models.planes;

import interfaces.IFly;

public abstract class Airplane implements IFly {

    private Long id;
    private String model;

    public Airplane() {};

    public Airplane(Long id, String model) {
        this.id = id;
        this.model = model;
    }

    @Override
    public String toString() {
        return  id + model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

}

