package parkinglot;

import parkinglot.exceptions.InvalidReceiptException;
import parkinglot.exceptions.NoSpaceInParkingLotException;

import java.util.List;

public class GraduateParkingLotBoy {
    final private List<ParkingLot> parkingLots;

    public GraduateParkingLotBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Receipt park(Car car) {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.hasFreeSpaces()) {
                return parkingLot.park(car);
            }
        }
        throw new NoSpaceInParkingLotException("No parking space!");
    }

    public Car pickBy(Receipt receipt) {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.containsCarBy(receipt)) {
                return parkingLot.pickBy(receipt);
            }
        }
        throw new InvalidReceiptException("Invalid receipt!");
    }
}
