package com.thoughtworks;

public interface IParkingBoy {
    Ticket parking(Car car);

    Car pickUp(Ticket ticket);

    boolean canParking();
}