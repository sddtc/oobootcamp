package parkinglot;

import parkinglot.exceptions.NoSpaceInParkingLotException;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SmartParkingLotBoy {
    private List<ParkingLot> parkingLots;

    public SmartParkingLotBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }


    public Receipt park(Car car) {
        Optional<ParkingLot> parkingLot = this.parkingLots.stream()
                .max(Comparator.comparing(ParkingLot::availableSpaces));
        if (parkingLot.isPresent()) {
            return parkingLot.get().park(car);
        }
        throw new NoSpaceInParkingLotException("No parking space!");
    }
}
