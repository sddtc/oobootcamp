package parkinglot;

import java.util.List;

public class ParkingLotManager {
    private List<ParkingLotBoy> parkingLotBoys;
    public ParkingLotManager(List<ParkingLotBoy> parkingLotBoys) {
        this.parkingLotBoys = parkingLotBoys;
    }


    public Receipt park(Car car) {
        return parkingLotBoys.get(0).park(car);
    }
}
