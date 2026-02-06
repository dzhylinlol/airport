package models.people;

import interfaces.IFly;
import interfaces.IPerformDuty;
import models.infrastructure.Flight;

import java.util.List;
import java.util.Objects;

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
        super(id, firstName, lastName, employeeId, yearsOfExperience);
        this.languages = languages;
        this.isPurser = isPurser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        FlightAttendant flightAttendant = (FlightAttendant) o;

        if (this.hashCode() != flightAttendant.hashCode()) return false;
        return Objects.equals(languages, flightAttendant.languages) && Objects.equals(isPurser, flightAttendant.isPurser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), languages, isPurser);
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

