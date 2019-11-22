package com.thoughtworks;

public class Manager extends SmartBoy {

    private ParkingBoy parkingBoy;

	public void addBoy(ParkingBoy parkingBoy) {
        this.parkingBoy=parkingBoy;
    }

    @Override
    public Ticket parking(Car car) {
        // TODO Auto-generated method stub
        if(parkingBoy.canParking()){
            return parkingBoy.parking(car);
        }
        return super.parking(car);
    }
}
