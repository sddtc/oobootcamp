package parkinglot;

import parkinglot.exceptions.NoSpaceInParkingLotException;

import java.util.List;

public class ParkingLotManager {
    private List<ParkingLotBoy> parkingLotBoys;

    public ParkingLotManager(List<ParkingLotBoy> parkingLotBoys) {
        this.parkingLotBoys = parkingLotBoys;
    }


    public Receipt park(Car car) {
        for (ParkingLotBoy parkingLotBoy : parkingLotBoys) {
            if (parkingLotBoy.hasAvailableParkingLot()) {
                return parkingLotBoy.park(car);
            }
        }
        throw new NoSpaceInParkingLotException("No parking space!");
    }
}
