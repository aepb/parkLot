package com.thoughtworks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingBoy implements IParkingBoy {

	private List<ParkLot> parkLots = new ArrayList<>();

	public Ticket parking(Car car) {
		for (ParkLot parkLot : parkLots) {
			if(!parkLot.isFull()){
				return parkLot.park(car);
			}
		}
		throw new ParkingLotException("PARTLOT_FULL");
	}

	public void addParkLot( ParkLot... parkLots) {
		this.parkLots.addAll(Arrays.asList(parkLots));
	}

	public Car pickUp(Ticket ticket) {
		return ticket.getParkLot().pickUp(ticket);
	}
	public boolean canParking(){
		return parkLots.stream().filter(p->!p.isFull()).count()>0;
	}
}
