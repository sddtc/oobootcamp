package parkinglot;

import parkinglot.exceptions.InvalidReceiptException;
import parkinglot.exceptions.NoSpaceInParkingLotException;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SuperParkingBoy extends ParkingLotBoy {

    public SuperParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public Receipt park(Car car) {
        Optional<ParkingLot> parkingLot = parkingLots.stream().max(Comparator.comparing(ParkingLot::availableSpacesRate));
        if (parkingLot.isPresent()) {
            return parkingLot.get().park(car);
        }
        throw new NoSpaceInParkingLotException("No parking space!");
    }
}
