package com.thoughtworks;

public class SmartBoy {

	private ParkLot parkLot;
	public void addParkLot(ParkLot parkLot) {
		this.parkLot=parkLot;
	}

	public Ticket parking(Car car) {
		return parkLot.park(car);
	}

}
