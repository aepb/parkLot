package com.thoughtworks;

import org.junit.Assert;
import org.junit.Test;

public class ParkingLotTest{

    @Test
    public void givenEmptyParkLotAndCarWhenParkingThenGetTicket(){
        ParkLot parkLot=new ParkLot();
        Car car=new Car();
        Ticket ticket= parkLot.Park(car);
        Assert.assertNotNull(ticket);
        Assert.assertEquals(car.getNumber(), ticket.getCarNumber());

    }

}