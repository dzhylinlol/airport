package com.solvd.airports.models.people;

public class CheckInStaff extends Person {
    private String airline;

    public CheckInStaff() {};

    public CheckInStaff(String airline) {
        super(id, firstName, lastName);
        this.airline = airline;
    }

}
