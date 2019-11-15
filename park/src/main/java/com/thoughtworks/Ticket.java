package com.thoughtworks;

import java.util.UUID;

public class Ticket {

    private String carNumber;
    private String token;
    private ParkLot parkLot;
    public Ticket(String carNumber,ParkLot parkLot) {
        super();
        this.carNumber = carNumber;
        this.token=UUID.randomUUID().toString();
        this.parkLot=parkLot;
    }

    public String getToken() {
        return token;
    }
    public String getCarNumber() {
		return this.carNumber;
    }

	public Object getParkLot() {
		return this.parkLot;
	}
    


}
