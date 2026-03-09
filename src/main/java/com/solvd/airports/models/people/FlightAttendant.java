package com.solvd.airports.models.people;

import com.solvd.airports.interfaces.IPerformDuty;
import com.solvd.airports.models.infrastructure.Flight;

import java.util.List;

public class FlightAttendant extends CrewMember implements IPerformDuty {
    private List<String> languages;
    private Boolean isPurser;

    public FlightAttendant() {}

    public FlightAttendant(Long id,
                           String firstName,
                           String lastName,
                           String employeeId,
                           Integer yearsOfExperience,
                           List<String> languages,
                           Boolean isPurser) {
        super(id, firstName, lastName,employeeId, yearsOfExperience);
        this.languages = languages;
        this.isPurser = isPurser;
    }

    @Override
    public String toString() {
        return  "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                (isPurser ? " (Purser)" : "");
    }

    @Override
    public String getRole() {
        return "Flight Attendant" + (isPurser ? " (Purser)" : "");
    }

    @Override
    public void performDuty(Flight flight) {
        System.out.println("Flight Attendant" + " " + getFirstName() + " " + getLastName() + " "
                + "doing service onboard for " + flight.getAirplane().getModel()
                + (isPurser ? " is a main FA " : " is a FA "));
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public Boolean getIsPurser() {
        return isPurser;
    }

    public void setIsPurser(Boolean isPurser) {
        this.isPurser = isPurser;
    }

}

