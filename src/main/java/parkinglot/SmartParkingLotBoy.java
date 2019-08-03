package parkinglot;

import parkinglot.exceptions.NoSpaceInParkingLotException;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SmartParkingLotBoy extends ParkingLotBoy {

    public SmartParkingLotBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
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
