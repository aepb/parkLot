package com.thoughtworks;

import java.util.HashMap;
import java.util.Map;

public class ParkLot {

    private Map<Ticket, Car> parkDatas = new HashMap<>();
    private int totalSpaceCount;

    public ParkLot(int totalSpaceCount) {
        super();
        if (totalSpaceCount <= 0) {
            throw new ParkingLotException("INVALID_SPACE_TOTALCOUNT");
        }
        this.totalSpaceCount = totalSpaceCount;
    }

    public Ticket Park(Car car) {
        if (parkDatas.size() < totalSpaceCount) {
            Ticket ticket = new Ticket(car.getNumber());
            parkDatas.put(ticket, car);
            return ticket;
        } else {
             throw new ParkingLotException("PARTLOT_FULL");
        }

    }

    public Car pickUp(Ticket ticket) {
        if (parkDatas.containsKey(ticket)) {
            Car car = parkDatas.get(ticket);
            parkDatas.remove(ticket);
            return car;
        } else {
            throw new ParkingLotException("INVALID_TICKET");
        }
    }

}