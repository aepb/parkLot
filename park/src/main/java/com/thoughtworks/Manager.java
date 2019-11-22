package com.thoughtworks;

import java.util.ArrayList;
import java.util.List;

public class Manager extends SmartBoy {

    private List<IParkingBoy> boys=new ArrayList<>();

	public void addBoy(IParkingBoy boy) {
        this.boys.add(boy);
    }

    @Override
    public Ticket parking(Car car) {
        for (IParkingBoy boy : boys) {
            if(boy.canParking()){
               return boy.parking(car);
            }
        }
        return super.parking(car);
    }
}
