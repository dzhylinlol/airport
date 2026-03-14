package com.solvd.airports.models.people;

import com.solvd.airports.interfaces.IPerformDuty;
import com.solvd.airports.models.infrastructure.Flight;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Pilot extends CrewMember implements IPerformDuty {

    private static final Logger LOGGER = LogManager.getLogger(Pilot.class);

    private String licenseNumber;
    private String rank;

    public Pilot() {
    }

    public Pilot(Long id,
                 String firstName,
                 String lastName,
                 String employeeId,
                 Integer yearsOfExperience,
                 String licenseNumber,
                 String rank) {
        super(id, firstName, lastName, employeeId, yearsOfExperience);
        this.licenseNumber = licenseNumber;
        this.rank = rank;
    }

    @Override
    public String getRole() {
        return "Pilot (" + rank + "), License: " + licenseNumber;
    }

    @Override
    public void performDuty(Flight flight) {
        LOGGER.info("Pilot {} {} operating the craft {}",getFirstName(), getLastName(), flight.getAirplane().getModel());
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                '}';
    }

}
