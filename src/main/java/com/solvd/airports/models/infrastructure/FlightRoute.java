package com.solvd.airports.models.infrastructure;

import java.time.Duration;
import java.time.LocalDateTime;

public record FlightRoute(
        Airport originAirport,
        Airport destinationAirport,
        LocalDateTime departureTime,
        LocalDateTime arrivalTime
)
{
    public FlightRoute{
        if (departureTime.isAfter(arrivalTime)) {
            throw new IllegalArgumentException("Departure must be before arrival");
        }
    }

    public long getFlightDurationInMinutes() {
        return Duration.between(departureTime, arrivalTime).toMinutes();
    }

}
