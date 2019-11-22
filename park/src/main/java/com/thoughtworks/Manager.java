package com.thoughtworks;

import java.util.ArrayList;
import java.util.List;

public class Manager extends SmartBoy {

    private List<IParkingBoy> boys = new ArrayList<>();

    public void addBoy(IParkingBoy boy) {
        this.boys.add(boy);
    }

    @Override
    public Ticket parking(Car car) {
        IParkingBoy firstParkingBoy = boys.stream().filter(p -> p.getClass() == ParkingBoy.class && p.canParking())
                .findFirst().get();
        if (firstParkingBoy != null) {
            return firstParkingBoy.parking(car);
        }
        IParkingBoy firstSmartBoy = boys.stream().filter(p -> p.getClass() == ParkingBoy.class && p.canParking())
                .findFirst().get();
        if (firstSmartBoy != null) {
            return firstSmartBoy.parking(car);
        }
        return super.parking(car);
    }
}
