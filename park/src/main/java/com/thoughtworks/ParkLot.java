package com.thoughtworks;

import java.util.HashMap;
import java.util.Map;

public class ParkLot {

    private Map<Ticket, Car> parkDatas = new HashMap<>();
    private int maxSlotCount;

    public ParkLot(int maxSlotCount) {
        super();
        if (maxSlotCount <= 0) {
            throw new ParkingLotException("INVALID_MAX_SLOT_COUNT");
        }
        this.maxSlotCount = maxSlotCount;
    }

    public Ticket park(Car car) {
        if (parkDatas.size() < maxSlotCount) {
            Ticket ticket = new Ticket(car.getNumber(), this);
            parkDatas.put(ticket, car);
            return ticket;
        } else {
            throw new ParkingLotException("PARTLOT_FULL");
        }

    }

    public boolean isFull() {
        return this.parkDatas.size() >= maxSlotCount;
    }

    public Car pickUp(Ticket ticket) {
        if (parkDatas.containsKey(ticket)) {
            return parkDatas.remove(ticket);
        } else {
            throw new ParkingLotException("INVALID_TICKET");
        }
    }

}
