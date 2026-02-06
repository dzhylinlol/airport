package models.people;


import interfaces.IPerformDuty;
import models.infrastructure.Flight;
import models.planes.PassengerPlane;

import java.util.Objects;

public class Pilot extends CrewMember implements IPerformDuty {

    private String licenseNumber;
    private String rank;

    public Pilot() {};

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
    public String toString() {
        return "Pilot{" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                '}';
    }

    @Override
    public String getRole() {
        return "Pilot (" + rank + "), License: " + licenseNumber;
    }
    @Override
    public void performDuty(Flight flight) {
        System.out.println("Pilot" + " " + getFirstName() + " " + getLastName() + " " + "operating the aircraft" + flight.getAirplane().getModel());
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

}
