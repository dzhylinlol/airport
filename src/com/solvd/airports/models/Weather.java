package com.solvd.airports.models;

public enum Weather {
    STORM(false),
    CLOUDY(true),
    SUNNY(true),
    RAINY(false);

    final boolean flyable;

    Weather(boolean flyable) {
        this.flyable = flyable;
    }

    public boolean isFlyable() {
        return flyable;
    }
}
