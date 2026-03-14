package com.solvd.airports.models.people;

import com.solvd.airports.interfaces.IPerformDuty;
import com.solvd.airports.models.infrastructure.Flight;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class FlightAttendant extends CrewMember implements IPerformDuty {

    private static final Logger LOGGER = LogManager.getLogger(FlightAttendant.class);

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
        LOGGER.info("Flight attendant {} {} serving on {} as {}",
                getFirstName(),
                getLastName(),
                flight.getAirplane().getModel(),
                isPurser ? "Purser" : "Flight Attendant");
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

