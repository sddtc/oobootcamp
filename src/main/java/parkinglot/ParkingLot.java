package parkinglot;

import parkinglot.exception.InvalidReceiptException;
import parkinglot.exception.NoParkingException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int capacity;
    private Map<ParkingLotReceipt, Car> parkingLotReceipts = new HashMap<>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public ParkingLotReceipt park(Car car) throws NoParkingException {
        if (parkingLotReceipts.size() >= this.capacity) {
            throw new NoParkingException("Can\'t stop car!");
        }
        return dispatchReceipt(car);
    }

    public Car fetchOutCar(ParkingLotReceipt receipt) throws InvalidReceiptException {
        if (receipt == null || !isReceiptValid(receipt)) {
            throw new InvalidReceiptException("isReceiptValid receipt");
        }

        return parkingLotReceipts.remove(receipt);
    }

    private ParkingLotReceipt dispatchReceipt(Car car) {
        ParkingLotReceipt receipt = new ParkingLotReceipt();
        parkingLotReceipts.put(receipt, car);
        return receipt;
    }

    private boolean isReceiptValid(ParkingLotReceipt receipt) {
        return parkingLotReceipts.containsKey(receipt);
    }
}
