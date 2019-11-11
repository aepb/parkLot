package com.thoughtworks;

import java.util.UUID;

public class Ticket {

    private String carNumber;
    private String token;

    public Ticket(String carNumber) {
        super();
        this.carNumber = carNumber;
        this.token=UUID.randomUUID().toString();
    }

    public String getToken() {
        return token;
    }
    public String getCarNumber() {
		return this.carNumber;
    }
    


}
