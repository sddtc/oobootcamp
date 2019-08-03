package parkinglot;

import org.junit.Assert;
import org.junit.Test;
import parkinglot.exceptions.InvalidReceiptException;
import parkinglot.exceptions.NoSpaceInParkingLotException;


public class ParkingLotTest {
    @Test
    public void should_return_a_receipt_when_park_1_car_given_1_free_space() {
        ParkingLot parkingLot = new ParkingLot(1);
        Receipt receipt = parkingLot.park(new Car());

        Assert.assertNotNull(receipt);
    }

    @Test
    public void should_return_two_diff_receipts_when_park_2_cars_give_2_free_spaces() {
        ParkingLot parkingLot = new ParkingLot(2);
        Receipt receipt = parkingLot.park(new Car());
        Receipt receipt2 = parkingLot.park(new Car());

        Assert.assertNotSame(receipt, receipt2);
    }

    @Test(expected = NoSpaceInParkingLotException.class)
    public void should_return_error_when_park_2_cars_given_1_free_space() {
        ParkingLot parkingLot = new ParkingLot(1);
        Assert.assertNotNull(parkingLot.park(new Car()));
        parkingLot.park(new Car());
    }

    @Test(expected = NoSpaceInParkingLotException.class)
    public void should_throw_error_when_park_1_car_given_0_free_space() {
        ParkingLot parkingLot = new ParkingLot(0);
        parkingLot.park(new Car());
    }

    @Test
    public void should_pick_car_success_when_pick_1_car_given_valid_receipt() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        Receipt receipt = parkingLot.park(car);

        Assert.assertSame(car, parkingLot.pickBy(receipt));
    }

    @Test(expected = InvalidReceiptException.class)
    public void should_throw_error_when_pick_1_car_given_without_receipt() {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.pickBy(null);
    }

    @Test(expected = InvalidReceiptException.class)
    public void should_throw_error_when_pick_1_car_given_invalid_receipt() {
        ParkingLot parkingLot = new ParkingLot(1);
        Receipt invalidReceipt = new Receipt();
        Car myCar = new Car();
        parkingLot.park(myCar);
        Assert.assertNotSame(myCar, parkingLot.pickBy(invalidReceipt));
    }

    @Test(expected = InvalidReceiptException.class)
    public void should_throw_error_when_pick_1_car_twice_given_valid_receipt() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car myCar = new Car();
        Receipt receipt = parkingLot.park(myCar);
        parkingLot.pickBy(receipt);
        parkingLot.pickBy(receipt);
    }
}
