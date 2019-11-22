package com.thoughtworks;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class ManagerTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    @Test
    public void give1Manager1EmptyParkingLotWhenParkingThenGetParkingLot1sTicket(){
        //give
        Manager Manager = new Manager();
        ParkLot parkLot=new ParkLot(10,"001");
        Manager.addParkLot(parkLot);

        Car car=new Car("s001");
        //when
        Ticket ticket= Manager.parking(car);
        //then
        Assert.assertNotNull(ticket);
        Assert.assertEquals(car.getNumber(), ticket.getCarNumber());
        Assert.assertEquals(parkLot, ticket.getParkLot());
        Assert.assertEquals(parkLot.getNumber(), ticket.getParkLot().getNumber());
    }
    
    @Test
    public void give1Manager0SlotLeftParkingLot1And1SlotLeftParkLot2WhenParkingThenGetParkingLot2sTicket()
    {
        Manager Manager = new Manager();
        ParkLot parkLot1=new ParkLot(1,"001");
        parkLot1.park(new Car("S001"));
        ParkLot parkLot2=new ParkLot(1,"002");
        Manager.addParkLot(parkLot1);
        Manager.addParkLot(parkLot2);
        //when
        Ticket ticket= Manager.parking(new Car("S002"));
        Assert.assertNotNull(ticket);
        Assert.assertEquals(parkLot2, ticket.getParkLot() );
        Assert.assertEquals("S002", ticket.getCarNumber());
    }
    @Test
    public void give1Manager1SlotLeftParkingLot1And0SlotLeftParkLot2WhenParkingThenGetParkingLot1sTicket()
    {
        Manager Manager = new Manager();
        ParkLot parkLot1=new ParkLot(1,"001");
        
        ParkLot parkLot2=new ParkLot(1,"002");
        parkLot2.park(new Car("S001"));
        Manager.addParkLot(parkLot1);
        Manager.addParkLot(parkLot2);
        //when
        Ticket ticket= Manager.parking(new Car("S002"));
        Assert.assertNotNull(ticket);
        Assert.assertEquals(parkLot1, ticket.getParkLot() );
        Assert.assertEquals("S002", ticket.getCarNumber());
    }

    @Test
    public void give1Manager1SlotLeftParkingLot1And1SlotLeftParkLot2WhenParkingThenGetParkingLot1sTicket(){
        Manager Manager = new Manager();
        ParkLot parkLot1=new ParkLot(1,"001");
        
        ParkLot parkLot2=new ParkLot(1,"002");
        Manager.addParkLot(parkLot1);
        Manager.addParkLot(parkLot2);
        //when
        Ticket ticket= Manager.parking(new Car("S002"));
        Assert.assertNotNull(ticket);
        Assert.assertEquals(parkLot1, ticket.getParkLot() );
        Assert.assertEquals("S002", ticket.getCarNumber());
    }

    @Test
    public void give1Manager1SlotLeftParkingLot1And2SlotLeftParkLot2WhenParkingThenGetParkingLot2sTicket(){
        Manager Manager = new Manager();
        ParkLot parkLot1=new ParkLot(1,"001");
        
        ParkLot parkLot2=new ParkLot(2,"002");
        Manager.addParkLot(parkLot1);
        Manager.addParkLot(parkLot2);
        //when
        Ticket ticket= Manager.parking(new Car("S002"));
        Assert.assertNotNull(ticket);
        Assert.assertEquals(parkLot2, ticket.getParkLot() );
        Assert.assertEquals("S002", ticket.getCarNumber());
    }
    @Test
    public void give1Manager0SlotLeftParkingLot1And0SlotLeftParkLot2WhenParkingThenCantParkCar(){

        Manager Manager = new Manager();
        ParkLot parkLot1=new ParkLot(1,"001");
        parkLot1.park(new Car("S001"));
        ParkLot parkLot2=new ParkLot(1,"002");
        parkLot2.park(new Car("S002"));
        Manager.addParkLot(parkLot1);
        Manager.addParkLot(parkLot2);
        //when
        Ticket ticket= Manager.parking(new Car("S003"));
        Assert.assertNull(ticket);
        
    }

    @Test
    public void give0SlotLeftParkLotAnd0SlotsLeftParkLotAndManagerWhenPickupThenGetCar()
    {
        Manager Manager = new Manager();
        ParkLot parkLot1=new ParkLot(1,"001");
        ParkLot parkLot2=new ParkLot(1,"002");
        Manager.addParkLot(parkLot1);
        Manager.addParkLot(parkLot2);
        Ticket ticket= Manager.parking(new Car("S003"));
        
        
        Car car= Manager.pickUp(ticket);
        Assert.assertNotNull(car);
        Assert.assertEquals("S003", car.getNumber());
    }

    @Test
    public void giveManagerAndInvalidTicketsWhenPickupThenGetCar()
    {
         //given
         Manager Manager=new  Manager();
         ParkLot parkLot1=new ParkLot(2,"001");
         ParkLot parkLot2=new ParkLot(2,"002");
         Manager.addParkLot(parkLot1);
         Manager.addParkLot(parkLot2);
 
         Manager.parking(new Car("s001"));
         Manager.parking(new Car("s002"));

         Ticket ticket= Manager.parking(new Car("s003"));
         Manager.pickUp(ticket);
         //when
         
        
         thrown.expect(ParkingLotException.class);
         thrown.expectMessage("INVALID_TICKET");
         Manager.pickUp(ticket);
    }

    @Test
    public void Give1Manager1EmptyParkingLotAnd1ParkingBoy1EmptyParkingWhenParkingThenGetParkingLot2sTicket(){
        Manager manager=new  Manager();
        ParkLot parkLot1=new ParkLot(1,"001");
        manager.addParkLot(parkLot1);

        ParkingBoy parkingBoy=new ParkingBoy();
        ParkLot parkLot2=new ParkLot(1, "002");
        parkingBoy.addParkLot(parkLot2);

        manager.addBoy(parkingBoy);

        Ticket ticket=manager.parking(new Car("C001"));
        Assert.assertNotNull(ticket);
        Assert.assertEquals(ticket.getCarNumber(), "C001");
        Assert.assertEquals(ticket.getParkLot(), parkLot2);

    }

}