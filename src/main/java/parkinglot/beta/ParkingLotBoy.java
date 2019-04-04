package parkinglot.beta;

import parkinglot.beta.exceptions.NoSpaceInParkingLotException;

import java.util.List;

public class ParkingLotBoy {
    final private List<ParkingLot> parkingLots;

    public ParkingLotBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Receipt park(Car car) {
        for (ParkingLot parkingLot : parkingLots) {
            return parkingLot.park(car);
        }
        throw new NoSpaceInParkingLotException("No parking space!");
    }
}