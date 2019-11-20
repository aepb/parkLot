package com.thoughtworks;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SmartBoyTest{

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    @Test
    public void give1SmartBoy1EmptyParkingLotWhenParkingThenGetParkingLot1sTicket(){
        //give
        SmartBoy smartBoy = new SmartBoy();
        ParkLot parkLot=new ParkLot(10,"001");
        smartBoy.addParkLot(parkLot);

        Car car=new Car("s001");
        //when
        Ticket ticket= smartBoy.parking(car);
        //then
        Assert.assertNotNull(ticket);
        Assert.assertEquals(car.getNumber(), ticket.getCarNumber());
        Assert.assertEquals(parkLot, ticket.getParkLot());
        Assert.assertEquals(parkLot.getNumber(), ticket.getParkLot().getNumber());
    }
    
}