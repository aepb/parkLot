package com.thoughtworks;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ParkingBoyTest{

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
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
    public void give0SlotLeftParkLotAnd2SlotsLeftParkLotAndParkingBoyWhenParkingThenGetParklot2sTicket()
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

    @Test
    public void give1SlotLeftParkLotAnd0SlotsLeftParkLotAndParkingBoyWhenParkingThenGetParklot1sTicket()
    {
         //given
         ParkingBoy parkingBoy=new  ParkingBoy();
         ParkLot parkLot1=new ParkLot(2);
         ParkLot parkLot2=new ParkLot(2);
         parkingBoy.addParkLot(parkLot1,parkLot2);
 
         Ticket ticket_001= parkingBoy.parking(new Car("s001"));
         parkingBoy.parking(new Car("s002"));

         parkingBoy.parking(new Car("s003"));
         parkingBoy.parking(new Car("s004"));

         parkingBoy.pickUp(ticket_001);

         //when

         Car car=new Car("s005");
         Ticket ticket= parkingBoy.parking(car);
         Assert.assertNotNull(ticket);
         Assert.assertEquals(car.getNumber(), ticket.getCarNumber());
         Assert.assertEquals(parkLot1, ticket.getParkLot()); 
    }
 
    @Test
    public void give0SlotLeftParkLotAnd0SlotsLeftParkLotAndParkingBoyWhenParkingThenGetNoTicket()
    {
         //given
         ParkingBoy parkingBoy=new  ParkingBoy();
         ParkLot parkLot1=new ParkLot(2);
         ParkLot parkLot2=new ParkLot(2);
         parkingBoy.addParkLot(parkLot1,parkLot2);
 
         parkingBoy.parking(new Car("s001"));
         parkingBoy.parking(new Car("s002"));

         parkingBoy.parking(new Car("s003"));
         parkingBoy.parking(new Car("s004"));


         //when

         Car car=new Car("s005");
         thrown.expect(ParkingLotException.class);
         thrown.expectMessage("PARTLOT_FULL");
         parkingBoy.parking(car);
        
    }
    @Test
    public void give0SlotLeftParkLotAnd0SlotsLeftParkLotAndParkingBoyWhenPickupThenGetCar()
    {
         //given
         ParkingBoy parkingBoy=new  ParkingBoy();
         ParkLot parkLot1=new ParkLot(2);
         ParkLot parkLot2=new ParkLot(2);
         parkingBoy.addParkLot(parkLot1,parkLot2);
 
         parkingBoy.parking(new Car("s001"));
         parkingBoy.parking(new Car("s002"));

         Ticket ticket= parkingBoy.parking(new Car("s003"));
         parkingBoy.parking(new Car("s004"));
         //when
        Car pickedCar= parkingBoy.pickUp(ticket);
         Assert.assertNotNull(pickedCar);
         Assert.assertEquals("s003",pickedCar.getNumber());
    }
    
    @Test
    public void giveParkingBoyAndInvalidTicketsWhenPickupThenGetCar()
    {
         //given
         ParkingBoy parkingBoy=new  ParkingBoy();
         ParkLot parkLot1=new ParkLot(2);
         ParkLot parkLot2=new ParkLot(2);
         parkingBoy.addParkLot(parkLot1,parkLot2);
 
         parkingBoy.parking(new Car("s001"));
         parkingBoy.parking(new Car("s002"));

         Ticket ticket= parkingBoy.parking(new Car("s003"));
         parkingBoy.pickUp(ticket);
         //when
         
        
         thrown.expect(ParkingLotException.class);
         thrown.expectMessage("INVALID_TICKET");
         parkingBoy.pickUp(ticket);
    }
}