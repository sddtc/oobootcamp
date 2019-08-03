package parkinglot;

import parkinglot.exceptions.InvalidReceiptException;
import parkinglot.exceptions.NoSpaceInParkingLotException;

import java.util.List;

public class ParkingLotManager {
    private List<ParkingLotBoy> parkingLotBoys;
    private List<ParkingLot> parkingLots;

    public ParkingLotManager(List<ParkingLotBoy> parkingLotBoys) {
        this.parkingLotBoys = parkingLotBoys;
    }

    public ParkingLotManager(List<ParkingLotBoy> parkingLotBoys, List<ParkingLot> parkingLots) {
        this.parkingLotBoys = parkingLotBoys;
        this.parkingLots = parkingLots;
    }

    public Receipt park(Car car) {
        for (ParkingLotBoy parkingLotBoy : parkingLotBoys) {
            if (parkingLotBoy.hasAvailableParkingLot()) {
                return parkingLotBoy.park(car);
            }
        }

        for (ParkingLot parkingLot : parkingLots) {
            return parkingLot.park(car);
        }
        throw new NoSpaceInParkingLotException("No parking space!");
    }

    public Car pickBy(Receipt receipt) {
        for (ParkingLotBoy parkingLotBoy : parkingLotBoys) {
            if(parkingLotBoy.own(receipt)) {
                return parkingLotBoy.pickBy(receipt);
            }
        }
        throw new InvalidReceiptException("Invalid receipt!");
    }
}
