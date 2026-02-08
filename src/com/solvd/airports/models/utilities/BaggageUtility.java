package com.solvd.airports.models.utilities;

import com.solvd.airports.models.infrastructure.Flight;
import com.solvd.airports.models.people.Passenger;

import java.util.List;

public class BaggageUtility {

    public static final int MAX_CAPACITY_KG = 1500;

    public static boolean hasOverWeight(Flight flight) {
       List<Passenger> passengers =  flight.getPassengers();
       int baggageSum = 0;
       for (Passenger passenger : passengers) {
           int pWeight = passenger.getBaggageWeightKG();
           baggageSum = baggageSum + pWeight;
       }
       return baggageSum > MAX_CAPACITY_KG;
    }
}
