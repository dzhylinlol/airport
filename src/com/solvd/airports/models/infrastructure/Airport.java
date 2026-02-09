package com.solvd.airports.models.infrastructure;

import com.solvd.airports.models.people.Passenger;
import com.solvd.airports.models.planes.Airplane;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Airport {
    private String code;
    private String name;
    private List<Terminal> terminals = new ArrayList<>();
    private List<Gate> gates = new ArrayList<>();

    public Airport() {};

    public Airport(String code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Airport {" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public List<Terminal> getTerminals() {
        return terminals;
    }
    public void setTerminals(List<Terminal> terminals) {
        this.terminals = terminals;
    }
    public List<Gate> getGates() {
        return gates;
    }
    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }
}




