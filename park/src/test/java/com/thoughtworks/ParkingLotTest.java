package com.thoughtworks;

import org.junit.Assert;
import org.junit.Test;

public class ParkingLotTest {

    @Test
    public void given1SpaceParkLotAndCarWhenParkingThenGetTicket() {
        //give
        ParkLot parkLot = new ParkLot(1);
        Car car = new Car();
        //when
        Ticket ticket = parkLot.Park(car);
        //then
        Assert.assertNotNull(ticket);
        Assert.assertEquals(car.getNumber(), ticket.getCarNumber());
    }

    @Test
    public void giveNoSpaceParkLotAndCarWhenParkingThenFailure() {
        //give
        ParkLot parkLot = new ParkLot(1);
        Car car1 = new Car();
        parkLot.Park(car1);
        Car car2 = new Car();
        //when
        Ticket ticket = parkLot.Park(car2);
        //then
        Assert.assertNull(ticket);

    }

    @Test
    public void giveParkLotAndTicketWhenPickupThenGetCar() {
        //give
        ParkLot parkLot = new ParkLot(1);
        Car car = new Car();
        Ticket ticket = parkLot.Park(car);
        //when
        Car pickedCar = parkLot.pickUp(ticket);
        //then
        Assert.assertTrue(pickedCar == car);

    }

    @Test
    public void giveParkLotAndNullTicketWhenPickupThenGetNull() {
        //give
        ParkLot parkLot = new ParkLot(1);
        //when
        Car car = parkLot.pickUp(null);
        //then
        Assert.assertNull(car);

    }

    @Test
    public void giveParkLotAndInvalidTicketWhenPickupThenGetNull() {
        //give
        ParkLot parkLot = new ParkLot(1);
        Ticket ticket = parkLot.Park(new Car());
        parkLot.pickUp(ticket);
        //when
        Car secondPickup = parkLot.pickUp(ticket);
        //then
        Assert.assertNull(secondPickup);

    }

}