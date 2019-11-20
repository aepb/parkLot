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
    
    @Test
    public void give1SmartBoy0SlotLeftParkingLot1And1SlotLeftParkLot2WhenParkingThenGetParkingLot2sTicket()
    {
        SmartBoy smartBoy = new SmartBoy();
        ParkLot parkLot1=new ParkLot(1,"001");
        parkLot1.park(new Car("S001"));
        ParkLot parkLot2=new ParkLot(1,"002");
        smartBoy.addParkLot(parkLot1);
        smartBoy.addParkLot(parkLot2);
        //when
        Ticket ticket= smartBoy.parking(new Car("S002"));
        Assert.assertNotNull(ticket);
        Assert.assertEquals(parkLot2, ticket.getParkLot() );
        Assert.assertEquals("S002", ticket.getCarNumber());
    }
    @Test
    public void give1SmartBoy1SlotLeftParkingLot1And0SlotLeftParkLot2WhenParkingThenGetParkingLot1sTicket()
    {
        SmartBoy smartBoy = new SmartBoy();
        ParkLot parkLot1=new ParkLot(1,"001");
        
        ParkLot parkLot2=new ParkLot(1,"002");
        parkLot2.park(new Car("S001"));
        smartBoy.addParkLot(parkLot1);
        smartBoy.addParkLot(parkLot2);
        //when
        Ticket ticket= smartBoy.parking(new Car("S002"));
        Assert.assertNotNull(ticket);
        Assert.assertEquals(parkLot1, ticket.getParkLot() );
        Assert.assertEquals("S002", ticket.getCarNumber());
    }

    @Test
    public void give1SmartBoy1SlotLeftParkingLot1And1SlotLeftParkLot2WhenParkingThenGetParkingLot1sTicket(){
        SmartBoy smartBoy = new SmartBoy();
        ParkLot parkLot1=new ParkLot(1,"001");
        
        ParkLot parkLot2=new ParkLot(1,"002");
        smartBoy.addParkLot(parkLot1);
        smartBoy.addParkLot(parkLot2);
        //when
        Ticket ticket= smartBoy.parking(new Car("S002"));
        Assert.assertNotNull(ticket);
        Assert.assertEquals(parkLot1, ticket.getParkLot() );
        Assert.assertEquals("S002", ticket.getCarNumber());
    }

    @Test
    public void give1SmartBoy1SlotLeftParkingLot1And2SlotLeftParkLot2WhenParkingThenGetParkingLot2sTicket(){
        SmartBoy smartBoy = new SmartBoy();
        ParkLot parkLot1=new ParkLot(1,"001");
        
        ParkLot parkLot2=new ParkLot(2,"002");
        smartBoy.addParkLot(parkLot1);
        smartBoy.addParkLot(parkLot2);
        //when
        Ticket ticket= smartBoy.parking(new Car("S002"));
        Assert.assertNotNull(ticket);
        Assert.assertEquals(parkLot2, ticket.getParkLot() );
        Assert.assertEquals("S002", ticket.getCarNumber());
    }

}