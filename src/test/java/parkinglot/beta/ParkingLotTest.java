package parkinglot.beta;

import org.junit.Assert;
import org.junit.Test;
import parkinglot.beta.exceptions.NoSpaceInParkingLotException;


public class ParkingLotTest {
    @Test
    public void should_return_a_receipt_when_paring_1_car_given_1_free_space_in_1_parking_lot() throws NoSpaceInParkingLotException {
        ParkingLot parkingLot = new ParkingLot(1);
        Receipt receipt = parkingLot.park(new Car());

        Assert.assertNotNull(receipt);
    }

    @Test
    public void should_return_two_diff_receipts_when_parking_2_cars_give_2_free_spaces_in_1_parking_lot() throws NoSpaceInParkingLotException {
        ParkingLot parkingLot = new ParkingLot(2);
        Receipt receipt = parkingLot.park(new Car());
        Receipt receipt2 = parkingLot.park(new Car());

        Assert.assertNotSame(receipt, receipt2);
    }

    @Test(expected = NoSpaceInParkingLotException.class)
    public void should_return_error_when_parking_2_cars_given_1_free_space_in_1_parking_lot() throws NoSpaceInParkingLotException {
        ParkingLot parkingLot = new ParkingLot(1);
        Assert.assertNotNull(parkingLot.park(new Car()));
        parkingLot.park(new Car());
    }

    @Test(expected = NoSpaceInParkingLotException.class)
    public void should_throw_error_when_parking_1_car_given_0_free_space_in_1_parking_lot() throws NoSpaceInParkingLotException {
        ParkingLot parkingLot = new ParkingLot(0);
        parkingLot.park(new Car());
    }

    
}
