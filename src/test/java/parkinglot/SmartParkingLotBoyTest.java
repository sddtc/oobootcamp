package parkinglot;

import org.junit.Assert;
import org.junit.Test;
import parkinglot.exceptions.InvalidReceiptException;

import static java.util.Arrays.asList;

public class SmartParkingLotBoyTest {
    @Test
    public void should_park_car_in_2nd_parkinglot_when_park_given_packinglot_boy_manage_2_parkinglots_with_1_empty_and_2_empty() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        SmartParkingLotBoy smartParkingLotBoy = new SmartParkingLotBoy(asList(parkingLot, parkingLot2));
        Car car = new Car();

        Receipt receipt = smartParkingLotBoy.park(car);

        Assert.assertSame(car, parkingLot2.pickBy(receipt));
    }

    @Test
    public void should_park_car_in_1st_parkinglot_when_park_given_packinglot_boy_manage_2_parkinglots_with_2_empty_and_1_empty() {
        ParkingLot parkingLot = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(1);
        SmartParkingLotBoy smartParkingLotBoy = new SmartParkingLotBoy(asList(parkingLot, parkingLot2));
        Car car = new Car();

        Receipt receipt = smartParkingLotBoy.park(car);

        Assert.assertSame(car, parkingLot.pickBy(receipt));
    }

    @Test
    public void should_park_car_in_2nd_parkinglot_when_park_given_packinglot_boy_manage_3_parkinglots_with_0_empty_1_empty_and_1_empty() {
        ParkingLot parkingLot = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(1);
        ParkingLot parkingLot3 = new ParkingLot(1);
        SmartParkingLotBoy smartParkingLotBoy = new SmartParkingLotBoy(asList(parkingLot, parkingLot2, parkingLot3));
        Car car = new Car();

        Receipt receipt = smartParkingLotBoy.park(car);

        Assert.assertSame(car, parkingLot2.pickBy(receipt));
    }

    @Test
    public void should_pick_car_success_when_pick_given_valid_receipt() {
        ParkingLot parkingLot = new ParkingLot(1);
        SmartParkingLotBoy smartParkingLotBoy = new SmartParkingLotBoy(asList(parkingLot));
        Car car = new Car();
        Receipt receipt = parkingLot.park(car);

        Assert.assertSame(car, smartParkingLotBoy.pickBy(receipt));
    }

    @Test(expected = InvalidReceiptException.class)
    public void should_pick_car_failed_when_pick_twice_given_valid_receipt() {
        ParkingLot parkingLot = new ParkingLot(1);
        SmartParkingLotBoy smartParkingLotBoy = new SmartParkingLotBoy(asList(parkingLot));
        Car car = new Car();
        Receipt receipt = parkingLot.park(car);

        smartParkingLotBoy.pickBy(receipt);
        smartParkingLotBoy.pickBy(receipt);
    }

    @Test
    public void should_pick_car_success_when_pick_given_smart_parkinglot_boy_manege_2_parkinglots_and_i_hava_valid_receipt_in_2nd_parkinglot() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        SmartParkingLotBoy smartParkingLotBoy = new SmartParkingLotBoy(asList(parkingLot, parkingLot2));
        Car car = new Car();
        Receipt receipt = parkingLot2.park(car);

        Assert.assertSame(car, smartParkingLotBoy.pickBy(receipt));
    }
}
