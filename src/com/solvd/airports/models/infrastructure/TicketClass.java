
// NOT IN USE, WIP
package com.solvd.airports.models.infrastructure;

public enum TicketClass {

    ECONOMY(2),
    BUSINESS(1),
    FIRST(0);

    private final int checkInPriority;

    TicketClass(int checkInPriority) {
        this.checkInPriority = checkInPriority;
    }

    public int getCheckInPriority() {
        return checkInPriority;
    }
}

