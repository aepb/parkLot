package com.thoughtworks;

import java.util.ArrayList;
import java.util.List;

public class SmartBoy {

	private List<ParkLot> parkLots=new ArrayList<>();
	public void addParkLot(ParkLot parkLot) {
		parkLots.add(parkLot);
	}

	public Ticket parking(Car car) {
		
		ParkLot target= parkLots.stream().sorted((o1,o2)->o2.getLeftSoltCount()-o1.getLeftSoltCount()).findFirst().get();
		
		return target.isFull()?null: target.park(car);
	}

	public Car pickUp(Ticket ticket) {
		return ticket.getParkLot().pickUp(ticket);
	}



}
