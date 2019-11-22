package com.thoughtworks;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Manager extends SmartBoy {

    private List<IParkingBoy> boys = new ArrayList<>();

    public void addBoy(IParkingBoy boy) {
        this.boys.add(boy);
    }

    @Override
    public Ticket parking(Car car) {
        Optional<IParkingBoy> firstParkingBoy = boys.stream().filter(p -> p.getClass() == ParkingBoy.class && p.canParking())
                .findFirst();
        if (firstParkingBoy.isPresent()) {
            return firstParkingBoy.get().parking(car);
        }
        Optional<IParkingBoy> firstSmartBoy = boys.stream().filter(p -> p.getClass() ==SmartBoy.class && p.canParking())
                .findFirst();
        if (firstSmartBoy.isPresent()) {
            return firstSmartBoy.get().parking(car);
        }
        return super.parking(car);
    }
}
