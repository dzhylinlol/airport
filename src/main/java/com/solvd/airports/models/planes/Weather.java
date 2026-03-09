package com.solvd.airports.models.planes;

public enum Weather {

    STORM(false),
    CLOUDY(true),
    SUNNY(true),
    RAINY(false);

    private final boolean flyable;

    Weather(boolean flyable) {
        this.flyable = flyable;
    }

    public boolean isFlyable() {
        return flyable;
    }

}
