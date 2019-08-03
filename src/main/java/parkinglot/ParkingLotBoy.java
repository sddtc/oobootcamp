package parkinglot;

import parkinglot.exceptions.InvalidReceiptException;

import java.util.List;

public class ParkingLotBoy {
    final protected List<ParkingLot> parkingLots;

    public ParkingLotBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
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
