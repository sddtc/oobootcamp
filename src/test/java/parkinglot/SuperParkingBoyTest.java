package parkinglot;

import org.junit.Assert;
import org.junit.Test;

import static java.util.Arrays.asList;

public class SuperParkingBoyTest {
    @Test
    public void should_park_in_1st_parkinglot_when_boy_park_car_given_he_manage_2_parkinglots_with_1_free_space_and_2_free_space() {
        ParkingLot parkingLot = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(3);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(asList(parkingLot, parkingLot2));
        parkingLot.park(new Car());
        parkingLot2.park(new Car());

        Car car = new Car();
        Receipt receipt = superParkingBoy.park(car);

        Assert.assertNotNull(receipt);
        Assert.assertSame(car, parkingLot.pickBy(receipt));
    }
}
