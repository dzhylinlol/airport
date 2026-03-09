package com.solvd.airports.models.infrastructure;

import com.solvd.airports.models.planes.Airplane;

public class Flight {
    private Long id;
    private Airport airportFrom;
    private Airport airportTo;
    private Airplane airplane;

    public Flight() {
    }

    public Flight(Long id){
        this.id = id;
    }

    public Flight(Long id,
                  Airport airportFrom,
                  Airport airportTo) {
        this.id = id;
        this.airportFrom = airportFrom;
        this.airportTo = airportTo;

    }

    @Override
    public String toString() {
        return "Flight {" +
                "id='" + id + '\'' +
                ", airportFrom=" + airportFrom +
                ", airportTo=" + airportTo +
                ", airplane='" + airplane + '\'' +
                '}';

    }

//    public void addPassenger(Passenger newPassenger) {
//        if (this.passengers == null) {
//            this.passengers = new ArrayList<>();
//            passengers.add(newPassenger);
//            return;
//        }
//
//        boolean hasSamePassenger = false;
//        for (Passenger oldPassenger : passengers) {
//            if (oldPassenger.equals(newPassenger)) {
//                hasSamePassenger = true;
//            }
//        }
//        if (hasSamePassenger == false) {
//            this.passengers.add(newPassenger);
//        }
//    }

//    public void addPassengers(List<Passenger> newPassengers) {
//        for (Passenger newOne : newPassengers) {
//            this.addPassenger(newOne);
//        }
//    }
//
//    public void addFlightAttendant(FlightAttendant flightAttendant) {
//        if (this.flightAttendants == null) {
//            this.flightAttendants = new ArrayList<>();
//        }
//        this.flightAttendants.add(flightAttendant);
//    }

    public void start() {
        System.out.println("Starting Flight...");
        airplane.takeOff();
    };

    public void finish() {
        airplane.land();
        System.out.println("Finishing Flight...");
    };

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public Airport getAirportFrom() {
        return airportFrom;
    }

   public void setAirportFrom(Airport airportFrom) {
        this.airportFrom = airportFrom;
   }

    public void setAirportTo(Airport airportTo) {
        this.airportTo = airportTo;
    }
    public Airport getAirportTo() {
        return airportTo;
    }
}
