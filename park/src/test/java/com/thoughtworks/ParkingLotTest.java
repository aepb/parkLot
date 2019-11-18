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
        new ParkLot(0,"000");
    }

    @Test
    public void given1SlotParkLotAndCarWhenParkingThenGetTicket() {
        // give
        ParkLot parkLot = new ParkLot(1,"001");
        Car car = new Car("abc");
        // when
        Ticket ticket = parkLot.park(car);
        // then
        Assert.assertNotNull(ticket);
        Assert.assertEquals(car.getNumber(), ticket.getCarNumber());
    }

    @Test
    public void giveNoSlotParkLotAndCarWhenParkingThenGetPartlotFull() {
        // give
        ParkLot parkLot = new ParkLot(1,"001");
        Car car1 = new Car("abc");
        parkLot.park(car1);
        Car car2 = new Car("bcd");
        // when

        thrown.expect(ParkingLotException.class);
        thrown.expectMessage("PARTLOT_FULL");

        parkLot.park(car2);

    }

    @Test
    public void giveParkLotAndTicketWhenPickupThenGetCar() {
        // give
        ParkLot parkLot = new ParkLot(1,"001");
        Car car = new Car("abc");
        Ticket ticket = parkLot.park(car);
        // when
        Car pickedCar = parkLot.pickUp(ticket);
        // then
        Assert.assertTrue(pickedCar == car);
        Assert.assertEquals(pickedCar.getNumber(),car.getNumber());
    }

   

    @Test
    public void giveParkLotAndInvalidTicketWhenPickupThenGetInvalidTicket() {
        // give
        ParkLot parkLot = new ParkLot(1,"001");
        Ticket ticket = parkLot.park(new Car("abc"));
        parkLot.pickUp(ticket);
        // when
        thrown.expect(ParkingLotException.class);
        thrown.expectMessage("INVALID_TICKET");
        parkLot.pickUp(ticket);


    }

}