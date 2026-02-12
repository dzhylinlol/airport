package com.solvd.airports.models.people;

import com.solvd.airports.exceptions.PersonHasCoronaVirusException;

public class SecurityAgent extends Person {
    private String checkpoint;

    public SecurityAgent() {};

    public SecurityAgent(Long id,
                         String firstName,
                         String lastName,
                         String checkpoint) {
        super(id, firstName, lastName);
        this.checkpoint = checkpoint;
    }

    @Override
    public String getRole(){
        return "Security Agent" + getFirstName() + " " + getLastName() + "is responsible for security check";
    }

    public void checkForCorona(Passenger passenger) throws PersonHasCoronaVirusException {
        if (passenger.getHasCorona()) {
            throw new PersonHasCoronaVirusException("Passenger has corona! Not allowed to proceed further");
        }
    }


    public String getCheckpoint(){
        return checkpoint;
    }

    public void setCheckpoint(String checkpoint){
        this.checkpoint = checkpoint;
    }


}


