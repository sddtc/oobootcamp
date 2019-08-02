package parkinglot;

import java.util.ArrayList;
import java.util.List;

public class SmartParkingLotBoy {
    private List<ParkingLot> parkingLots;

    public SmartParkingLotBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }


    public Receipt park(Car car) {
        return this.parkingLots.get(1).park(car);
    }
}
