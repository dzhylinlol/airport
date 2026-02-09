package com.solvd.airports.models.utilities;

import com.solvd.airports.exceptions.BaggageOverweightException;
import com.solvd.airports.models.infrastructure.Flight;
import com.solvd.airports.models.people.Passenger;
import com.solvd.airports.models.planes.PassengerPlane;

import java.util.List;

public class BaggageUtility {

    public static final int MAX_CAPACITY_KG = 1500;

    public static boolean hasOverWeight( final PassengerPlane passengerPlane) {
       List<Passenger> passengers =  passengerPlane.getPassengers();
       int baggageSum = 0;
       for (Passenger passenger : passengers) {
           int pWeight = passenger.getBaggageWeightKG();
           baggageSum = baggageSum + pWeight;
       }
       return baggageSum > MAX_CAPACITY_KG;
    }


    public static void checkOverWeight(PassengerPlane passengerPlane) {
        if (hasOverWeight(passengerPlane)) {
            throw new BaggageOverweightException("Baggage Overweight!");
        }
    }

}

