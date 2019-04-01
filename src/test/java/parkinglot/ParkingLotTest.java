package parkinglot;

import org.junit.Assert;
import org.junit.Test;
import parkinglot.exception.InvalidReceiptException;
import parkinglot.exception.NoParkingException;

public class ParkingLotTest {
    @Test
    public void should_parking_success_when_parking_car_given_one_parking_lot() throws NoParkingException {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLotReceipt receipt = parkingLot.park(new Car());

        Assert.assertNotNull(receipt);
    }

    @Test
    public void should_parking_success_when_parking_two_cars_given_two_receipts() throws NoParkingException {
        ParkingLot parkingLot = new ParkingLot(2);
        ParkingLotReceipt oneCarReceipt = parkingLot.park(new Car());
        ParkingLotReceipt anotherCarReceipt = parkingLot.park(new Car());

        Assert.assertNotSame(oneCarReceipt, anotherCarReceipt);
    }

    @Test(expected = NoParkingException.class)
    public void should_parking_fail_when_parking_car_given_zero_parking_lot() throws NoParkingException {
        ParkingLot parkingLot = new ParkingLot(0);
        parkingLot.park(new Car());
    }

    @Test(expected = NoParkingException.class)
    public void should_parking_fail_when_parking_two_cars_given_one_parking_lot() throws NoParkingException {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLotReceipt oneCarReceipt = parkingLot.park(new Car());

        parkingLot.park(new Car());
        Assert.assertNotNull(oneCarReceipt);
    }

    @Test
    public void should_return_my_car_when_fetch_out_my_car_given_a_receipt() throws NoParkingException, InvalidReceiptException {
        ParkingLot parkingLot = new ParkingLot(1);
        Car myCar = new Car();
        ParkingLotReceipt receipt = parkingLot.park(myCar);

        Assert.assertSame(myCar, parkingLot.fetchOutCar(receipt));
    }

    @Test(expected = InvalidReceiptException.class)
    public void should_throw_exception_when_fetch_out_car_given_zero_receipt() throws NoParkingException, InvalidReceiptException {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(new Car());

        parkingLot.fetchOutCar(null);
    }

    @Test(expected = InvalidReceiptException.class)
    public void should_throw_exception_when_fetch_out_car_given_invalid_receipt() throws NoParkingException, InvalidReceiptException {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLotReceipt invalidReceipt = new ParkingLotReceipt();
        parkingLot.park(new Car());

        parkingLot.fetchOutCar(invalidReceipt);
    }

    @Test(expected = InvalidReceiptException.class)
    public void should_throw_exception_when_fetch_out_car_twice_given_a_receipt() throws NoParkingException, InvalidReceiptException {
        ParkingLot parkingLot = new ParkingLot(1);
        Car myCar = new Car();
        ParkingLotReceipt parkingLotReceipt = parkingLot.park(myCar);

        Assert.assertSame(myCar, parkingLot.fetchOutCar(parkingLotReceipt));
        parkingLot.fetchOutCar(parkingLotReceipt);
    }
}
