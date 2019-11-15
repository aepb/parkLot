package com.thoughtworks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingBoy {

	private List<ParkLot> parkLots = new ArrayList<>();

	public Ticket parking(Car car) {
		for (ParkLot parkLot : parkLots) {
			if(!parkLot.isFull()){
				return parkLot.park(car);
			}
		}
		return null;
	}

	public void addParkLot( ParkLot... parkLots) {
		this.parkLots.addAll(Arrays.asList(parkLots));
	}

}
