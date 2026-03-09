package com.solvd.airports.models.infrastructure;

import java.util.ArrayList;
import java.util.List;

public class Airport {
    private String code;
    private String name;
    private List<Terminal> terminals = new ArrayList<>();

    public Airport() {};

    public Airport(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public Airport(String code, String name, List<Terminal> terminals) {
        this.code = code;
        this.name = name;
        this.terminals = terminals;

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

    public List<Terminal> getTerminals() {
        return terminals;
    }

    public void setTerminals(List<Terminal> terminals) {
        this.terminals = terminals;
    }
}




