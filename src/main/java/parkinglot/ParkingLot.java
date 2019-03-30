package parkinglot;

import parkinglot.exception.InvalidReceiptException;
import parkinglot.exception.NoParkingException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int size;
    private Map<String, Car> parkingLotReceipts = new HashMap<>();

    public ParkingLot(int size) {
        this.size = size;
    }

    public ParkingLotReceipt park(Car car) throws NoParkingException {
        if (this.size <= 0) {
            throw new NoParkingException("error");
        }
        return dispatchReceipt(car);
    }

    public boolean fetchOutCar(ParkingLotReceipt receipt) throws InvalidReceiptException {
        if (receipt == null || !isReceiptValid(receipt)) {
            throw new InvalidReceiptException("isReceiptValid receipt");
        }
        return true;
    }

    private void minusCarParkings() {
        this.size--;
    }

    private ParkingLotReceipt dispatchReceipt(Car car) {
        ParkingLotReceipt receipt = new ParkingLotReceipt();
        parkingLotReceipts.put(receipt.getReceipt(), car);
        minusCarParkings();
        return receipt;
    }

    private boolean isReceiptValid(ParkingLotReceipt receipt) {
        return parkingLotReceipts.containsKey(receipt.getReceipt());
    }
}
