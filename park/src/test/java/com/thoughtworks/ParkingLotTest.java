package com.thoughtworks;

import org.junit.Assert;
import org.junit.Test;

public class ParkingLotTest {

    @Test
    public void given1SpaceParkLotAndCarWhenParkingThenGetTicket() {
        ParkLot parkLot = new ParkLot(1);
        Car car = new Car();
        Ticket ticket = parkLot.Park(car);
        Assert.assertNotNull(ticket);
        Assert.assertEquals(car.getNumber(), ticket.getCarNumber());
    }

    @Test
    public void giveNoSpaceParkLotAndCarWhenParkingThenFailure() {
        ParkLot parkLot = new ParkLot(1);
        Car car1 = new Car();
        parkLot.Park(car1);

        Car car2 = new Car();
        Ticket ticket = parkLot.Park(car2);
        Assert.assertNull(ticket);

    }

    @Test
    public void giveParkLotAndTicketWhenPickupThenGetCar(){
        ParkLot parkLot=new ParkLot(1);
        Car car=new Car();
        Ticket ticket=parkLot.Park(car);

        Car pickedCar= parkLot.pickUp(ticket);
        Assert.assertTrue(pickedCar==car);

    }

}