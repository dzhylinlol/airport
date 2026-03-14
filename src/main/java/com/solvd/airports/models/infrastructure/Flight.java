package com.solvd.airports.models.infrastructure;

import com.solvd.airports.models.planes.Airplane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Flight {

    private static final Logger LOGGER = LogManager.getLogger(Flight.class);

    private Long id;
    private Airport airportFrom;
    private Airport airportTo;
    private Airplane airplane;

    public Flight() {
    }

    public Flight(Long id) {
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

    public void start() {
        LOGGER.info("Starting Flight...");
        airplane.takeOff();
    }

    ;

    public void finish() {
        airplane.land();
        LOGGER.info("Finishing Flight...");
    }

    ;

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
