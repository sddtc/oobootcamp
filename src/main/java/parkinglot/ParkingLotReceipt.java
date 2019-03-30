package parkinglot;

import java.util.UUID;

public class ParkingLotReceipt {
    private String receipt;

    public ParkingLotReceipt() {
        receipt = UUID.randomUUID().toString();
    }

    public String getReceipt() {
        return receipt;
    }
}
