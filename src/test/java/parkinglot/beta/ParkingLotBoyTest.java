package parkinglot.beta;

import org.junit.Assert;
import org.junit.Test;
import parkinglot.beta.exceptions.NoSpaceInParkingLotException;

import static java.util.Arrays.asList;

public class ParkingLotBoyTest {

    @Test
    public void should_parking_1_car_success_when_parkingboy_parking_1_car_given_2_parking_lots_with_free_space_1_2() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        ParkingLotBoy parkingLotBoy = new ParkingLotBoy(asList(parkingLot, parkingLot2));

        Car car = new Car();
        Receipt receipt = parkingLotBoy.park(car);
        Assert.assertSame(car, parkingLot.pickBy(receipt));
    }

    @Test
    public void should_parking_1_car_in_the_second_success_when_parkingboy_parking_1_car_given_2_parking_lots_with_free_space_2_1() {
        ParkingLot parkingLot = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(1);
        ParkingLotBoy parkingLotBoy = new ParkingLotBoy(asList(parkingLot, parkingLot2));

        Car car = new Car();
        Receipt receipt = parkingLotBoy.park(car);
        Assert.assertSame(car, parkingLot.pickBy(receipt));
    }

    @Test
    public void should_parking_1_car_in_the_second_success_when_parkingboy_parking_1_car_given_3_parking_lots_with_free_space_0_1_2() {
        ParkingLot parkingLot = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(1);
        ParkingLot parkingLot3 = new ParkingLot(2);
        ParkingLotBoy parkingLotBoy = new ParkingLotBoy(asList(parkingLot, parkingLot2, parkingLot3));

        Car car = new Car();
        Receipt receipt = parkingLotBoy.park(car);
        Assert.assertSame(car, parkingLot2.pickBy(receipt));
    }

    @Test(expected = NoSpaceInParkingLotException.class)
    public void should_parking_1_car_failed_when_parkingboy_parking_1_car_given_2_parking_lots_with_free_space_0_0() {
        ParkingLot parkingLot = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(0);
        ParkingLotBoy parkingLotBoy = new ParkingLotBoy(asList(parkingLot, parkingLot2));

        Car car = new Car();
        parkingLotBoy.park(car);
    }
}
