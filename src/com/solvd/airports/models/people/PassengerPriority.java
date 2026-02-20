package com.solvd.airports.models.people;

public enum PassengerPriority {

    STANDARD(4, false),
    SILVER(3, true),
    GOLD(2, true),
    PLATINUM(1, true),
    VIP(0, true);

    private final int boardingOrder;
    private final boolean loungeAccess;

    PassengerPriority(int boardingOrder,
                      boolean loungeAccess) {
        this.boardingOrder = boardingOrder;
        this.loungeAccess = loungeAccess;
    }

    public int getBoardingOrder() {
        return boardingOrder;
    }

    public boolean hasLoungeAccess() {
        return loungeAccess;
    }

}
