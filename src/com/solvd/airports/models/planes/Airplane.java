package com.solvd.airports.models.planes;

import com.solvd.airports.interfaces.IFly;
import com.solvd.airports.models.people.Pilot;

import java.util.ArrayList;
import java.util.List;

public abstract class Airplane<T> implements IFly {

    private Long id;
    private String model;
    private Boolean isBroken = false;
    private Pilot pilot;
    private List<T> load = new ArrayList<>();

    public Airplane() {
    }

    public Airplane(Long id, String model) {
        this.id = id;
        this.model = model;
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

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    public List<T> getLoad() {
        return load;
    }

    public void setLoad(List<T> load) {
        this.load = load;
    }

    @Override
    public String toString() {
        return model;
    }

}

