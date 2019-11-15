package com.thoughtworks;

import org.junit.Assert;
import org.junit.Test;

public class ParkingBoyTest{

    @Test
    public void give1ParkingBoy1EmptyParkingLotWhenParkingThenGetParkingLot1sTicket(){
        //give
        ParkingBoy parkingBoy=new ParkingBoy();
        ParkLot parkLot=new ParkLot(10);
        parkingBoy.addParkLot(parkLot);

        Car car=new Car("s001");
        //when
        Ticket ticket= parkingBoy.parking(car);
        //then
        Assert.assertNotNull(ticket);
        Assert.assertEquals(car.getNumber(), ticket.getCarNumber());
        Assert.assertEquals(parkLot, ticket.getParkLot());

    }
    
    @Test
    public void give()
    {
        //given
        ParkingBoy parkingBoy=new  ParkingBoy();
        ParkLot parkLot1=new ParkLot(2);
        ParkLot parkLot2=new ParkLot(2);
        parkingBoy.addParkLot(parkLot1,parkLot2);

        parkingBoy.parking(new Car("s001"));
        parkingBoy.parking(new Car("s002"));
        Car car=new Car("s003");
        //when
        Ticket ticket= parkingBoy.parking(car);
        Assert.assertNotNull(ticket);
        Assert.assertEquals(car.getNumber(), ticket.getCarNumber());
        Assert.assertEquals(parkLot2, ticket.getParkLot());

    }


    
}