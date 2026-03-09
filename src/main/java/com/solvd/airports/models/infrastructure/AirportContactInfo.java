package com.solvd.airports.models.infrastructure;

public record AirportContactInfo (  String airportCode,
                                    String phoneNumber,
                                    String email,
                                    String website
) {
}
