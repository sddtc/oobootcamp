package parkinglot.beta;

import org.junit.Assert;
import org.junit.Test;

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
}
