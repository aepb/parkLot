package com.thoughtworks;

import java.util.HashMap;
import java.util.Map;

public class ParkLot {

    private Map<Ticket,Car> parkDatas=new HashMap<>();
    
	public Ticket Park(Car car) {
        Ticket ticket= new Ticket(car.getNumber());
        parkDatas.put(ticket, car);
        return ticket;
	}

}
