package com.solvd.airports.utilities;

import com.solvd.airports.exceptions.BaggageOverweightException;
import com.solvd.airports.models.people.Passenger;
import com.solvd.airports.models.planes.PassengerPlane;

import java.util.List;

public class BaggageUtility {

    public static final int MAX_CAPACITY_KG = 1500;

    public static void checkOverWeight(final PassengerPlane passengerPlane) throws BaggageOverweightException {
        List<Passenger> passengers = passengerPlane.getPassengers();
        int baggageSum = 0;
        for (Passenger passenger : passengers) {
            int pWeight = passenger.getBaggageWeightKG();
            baggageSum = baggageSum + pWeight;
        }
        int extraWeight = MAX_CAPACITY_KG - baggageSum;
        if (extraWeight < 0) {
            throw new BaggageOverweightException("Plane has overweight" + extraWeight);
        }
    }
}

