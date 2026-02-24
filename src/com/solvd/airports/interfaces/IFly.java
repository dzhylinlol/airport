package com.solvd.airports.interfaces;

import com.solvd.airports.exceptions.PlaneIsBrokenExceptionException;

public interface IFly {

    void takeOff() throws PlaneIsBrokenExceptionException;

    void land();

}
