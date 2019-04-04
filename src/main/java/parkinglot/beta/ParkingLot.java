package parkinglot.beta;

import parkinglot.beta.exceptions.NoSpaceInParkingLotException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    final private int capacity;
    final private Map<Receipt, Car> parkingLot = new HashMap<>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public Receipt park(Car car) throws NoSpaceInParkingLotException {
        if (parkingLot.size() >= capacity) {
            throw new NoSpaceInParkingLotException("No parking space!");
        }
        Receipt receipt = new Receipt();
        parkingLot.put(receipt, car);
        return receipt;
    }

    public Car pickBy(Receipt receipt) {
        return parkingLot.get(receipt);
    }
}


