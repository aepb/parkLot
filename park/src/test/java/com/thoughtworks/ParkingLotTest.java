package com.thoughtworks;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ParkingLotTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    @Test
    public void ifMaxSlotEqualsZeroWhenCreateParklotThenGetInvalidMaxSlotCount() {
        thrown.expect(ParkingLotException.class);
        thrown.expectMessage("INVALID_MAX_SLOT_COUNT");
        new ParkLot(0);
    }

    @Test
    public void given1SlotParkLotAndCarWhenParkingThenGetTicket() {
        // give
        ParkLot parkLot = new ParkLot(1);
        Car car = new Car("abc");
        // when
        Ticket ticket = parkLot.Park(car);
        // then
        Assert.assertNotNull(ticket);
        Assert.assertEquals(car.getNumber(), ticket.getCarNumber());
    }

    @Test
    public void giveNoSlotParkLotAndCarWhenParkingThenGetParkingLotException() {
        // give
        ParkLot parkLot = new ParkLot(1);
        Car car1 = new Car("abc");
        parkLot.Park(car1);
        Car car2 = new Car("bcd");
        // when

        thrown.expect(ParkingLotException.class);
        thrown.expectMessage("PARTLOT_FULL");

        parkLot.Park(car2);

    }

    @Test
    public void giveParkLotAndTicketWhenPickupThenGetCar() {
        // give
        ParkLot parkLot = new ParkLot(1);
        Car car = new Car("abc");
        Ticket ticket = parkLot.Park(car);
        // when
        Car pickedCar = parkLot.pickUp(ticket);
        // then
        Assert.assertTrue(pickedCar == car);
        Assert.assertEquals(pickedCar.getNumber(),car.getNumber());
    }

    @Test
    public void giveParkLotAndNullTicketWhenPickupThenGetParkingLotException() {
        // give
        ParkLot parkLot = new ParkLot(1);
        // when
        thrown.expect(ParkingLotException.class);
        thrown.expectMessage("INVALID_TICKET");
        parkLot.pickUp(null);


    }

    @Test
    public void giveParkLotAndInvalidTicketWhenPickupThenGetGetParkingLotException() {
        // give
        ParkLot parkLot = new ParkLot(1);
        Ticket ticket = parkLot.Park(new Car("abc"));
        parkLot.pickUp(ticket);
        // when
        thrown.expect(ParkingLotException.class);
        thrown.expectMessage("INVALID_TICKET");
        parkLot.pickUp(ticket);


    }

}