package models.infrastructure;

import java.util.ArrayList;
import java.util.List;

public class Terminal {
    private String name;
    private List<Gate> gates = new ArrayList<>();

    public Terminal() {}

    public Terminal(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + gates;
    }

    public void addGate(Gate gate) {
        gates.add(gate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }
}

