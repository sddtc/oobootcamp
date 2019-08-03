package parkinglot;

import org.junit.Assert;
import org.junit.Test;
import parkinglot.exceptions.InvalidReceiptException;

import static java.util.Arrays.asList;

public class SuperParkingLotBoyTest {
    @Test
    public void should_park_in_1st_success_when_boy_park_given_boy_manage_2_parkinglots_with_free_space_1_2() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        SuperParkingLotBoy superParkingLotBoy = new SuperParkingLotBoy(asList(parkingLot, parkingLot2));
        parkingLot2.park(new Car());

        Car car = new Car();
        Receipt receipt = superParkingLotBoy.park(car);

        Assert.assertNotNull(receipt);
        Assert.assertSame(car, parkingLot.pickBy(receipt));
    }

    @Test
    public void should_park_in_2nd_success_when_park_given_boy_manage_2_parkinglots_with_capacity_2_1_and_free_spaces_1_1() {
        ParkingLot parkingLot = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(1);
        SuperParkingLotBoy superParkingLotBoy = new SuperParkingLotBoy(asList(parkingLot, parkingLot2));
        parkingLot.park(new Car());

        Car car = new Car();
        Receipt receipt = superParkingLotBoy.park(car);

        Assert.assertNotNull(receipt);
        Assert.assertSame(car, parkingLot2.pickBy(receipt));
    }

    @Test
    public void should_park_in_1st_success_when_park_car_given_boy_manage_2_parkinglots_with_capacity_1_1_with_free_space_1_1() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        SuperParkingLotBoy superParkingLotBoy = new SuperParkingLotBoy(asList(parkingLot, parkingLot2));

        Car car = new Car();
        Receipt receipt = superParkingLotBoy.park(car);

        Assert.assertNotNull(receipt);
        Assert.assertSame(car, parkingLot.pickBy(receipt));
    }

    @Test
    public void should_park_in_2nd_success_when_park_car_given_boy_manage_2_parkinglots_with_capacity_0_1_with_free_space_0_1() {
        ParkingLot parkingLot = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(1);
        SuperParkingLotBoy superParkingLotBoy = new SuperParkingLotBoy(asList(parkingLot, parkingLot2));

        Car car = new Car();
        Receipt receipt = superParkingLotBoy.park(car);

        Assert.assertNotNull(receipt);
        Assert.assertSame(car, parkingLot2.pickBy(receipt));
    }

    @Test
    public void should_pick_car_success_when_pick_given_valid_receipt() {
        ParkingLot parkingLot = new ParkingLot(1);
        SuperParkingLotBoy superParkingLotBoy = new SuperParkingLotBoy(asList(parkingLot));
        Car car = new Car();
        Receipt receipt = parkingLot.park(car);

        Assert.assertSame(car, superParkingLotBoy.pickBy(receipt));
    }

    @Test(expected = InvalidReceiptException.class)
    public void should_pick_car_failed_when_pick_twice_given_valid_receipt() {
        ParkingLot parkingLot = new ParkingLot(1);
        SuperParkingLotBoy superParkingLotBoy = new SuperParkingLotBoy(asList(parkingLot));
        Car car = new Car();
        Receipt receipt = parkingLot.park(car);

        superParkingLotBoy.pickBy(receipt);
        superParkingLotBoy.pickBy(receipt);
    }

    @Test
    public void should_pick_car_success_when_pick_given_boy_manage_2_parkinglots_and_valid_receipt_in_2nd_parkinglot() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        SuperParkingLotBoy superParkingLotBoy = new SuperParkingLotBoy(asList(parkingLot, parkingLot2));
        Car car = new Car();
        Receipt receipt = parkingLot2.park(car);

        Assert.assertSame(car, superParkingLotBoy.pickBy(receipt));
    }
}
