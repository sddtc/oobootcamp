package parkinglot;

import org.junit.Assert;
import org.junit.Test;

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
}
