package parkinglot;

import parkinglot.exceptions.NoSpaceInParkingLotException;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SuperParkingBoy {
    private List<ParkingLot> parkingLots;

    public SuperParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Receipt park(Car car) {
        Optional<ParkingLot> parkingLot = parkingLots.stream().max(Comparator.comparing(ParkingLot::availableSpacesRate));
        if (parkingLot.isPresent()) {
            return parkingLot.get().park(car);
        }
        throw new NoSpaceInParkingLotException("No parking space!");
    }

    public Car pickBy(Receipt receipt) {
        return parkingLots.get(0).pickBy(receipt);
    }
}
