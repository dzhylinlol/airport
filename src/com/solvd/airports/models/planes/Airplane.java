package com.solvd.airports.models.planes;

import com.solvd.airports.interfaces.IFly;

public abstract class Airplane implements IFly {

    private Long id;
    private String model;
    private Boolean isBroken;

    public Airplane() {};

    public Airplane(Long id, String model) {
        this.id = id;
        this.model = model;
    }

    public Airplane(Long id, String model, Boolean isBroken) {
        this.id = id;
        this.model = model;
        this.isBroken = isBroken;
    }

    @Override
    public String toString() {
        return  id + " - " + model;
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

    public Boolean getIsBroken() {
        return isBroken;
    }

    public void setIsBroken(Boolean isBroken) {
        this.isBroken = isBroken;
    }

}

