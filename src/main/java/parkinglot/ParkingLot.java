package parkinglot;

import parkinglot.exceptions.InvalidReceiptException;
import parkinglot.exceptions.NoSpaceInParkingLotException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    final private int capacity;
    final private Map<Receipt, Car> parkingLot = new HashMap<>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public Receipt park(Car car) {
        if (parkingLot.size() >= capacity) {
            throw new NoSpaceInParkingLotException("No parking space!");
        }
        Receipt receipt = new Receipt();
        parkingLot.put(receipt, car);
        return receipt;
    }

    public Car pickBy(Receipt receipt) {
        if (null == receipt || !parkingLot.containsKey(receipt)) {
            throw new InvalidReceiptException("Invalid receipt!");
        }
        return parkingLot.remove(receipt);
    }

    public boolean hasFreeSpaces() {
        return this.parkingLot.size() < capacity;
    }

    public boolean containsCarBy(Receipt receipt) {
        return parkingLot.containsKey(receipt);
    }
}


