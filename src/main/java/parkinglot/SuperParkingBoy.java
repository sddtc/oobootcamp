package parkinglot;

import java.util.List;

public class SuperParkingBoy {
    private List<ParkingLot> parkingLots;

    public SuperParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Receipt park(Car car) {
        return parkingLots.get(0).park(car);
    }
}
