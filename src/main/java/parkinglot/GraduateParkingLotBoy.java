package parkinglot;

import parkinglot.exceptions.NoSpaceInParkingLotException;

import java.util.List;

public class GraduateParkingLotBoy extends ParkingLotBoy {

    public GraduateParkingLotBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public Receipt park(Car car) {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.hasFreeSpaces()) {
                return parkingLot.park(car);
            }
        }
        throw new NoSpaceInParkingLotException("No parking space!");
    }
}
