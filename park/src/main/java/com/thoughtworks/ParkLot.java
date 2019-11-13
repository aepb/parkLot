package com.thoughtworks;

import java.util.HashMap;
import java.util.Map;

public class ParkLot {

    private Map<Ticket, Car> parkDatas = new HashMap<>();
    private int totalSpaceCount;

    public ParkLot(int totalSpaceCount) {
        super();
        this.totalSpaceCount = totalSpaceCount;
    }

    public Ticket Park(Car car) {
        if(parkDatas.size()<totalSpaceCount){
            Ticket ticket = new Ticket(car.getNumber());
            parkDatas.put(ticket, car);
            return ticket;
        }else{
            return null;
        }

    }

}
