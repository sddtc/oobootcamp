package parkinglot.beta;

import parkinglot.beta.exceptions.NoSpaceInParkingLotException;
import parkinglot.exception.NoParkingException;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    final private int capacity;
    final private List<Car> parkingLot = new ArrayList<>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public Receipt park(Car car) throws NoSpaceInParkingLotException {
        if (parkingLot.size() >= capacity) {
            throw new NoSpaceInParkingLotException("No parking space!");
        }
        parkingLot.add(car);
        return new Receipt();
    }
}


