package parkinglot;

import org.junit.Assert;
import org.junit.Test;

import static java.util.Arrays.asList;

public class ParkingLotManagerTest {

    @Test
    public void should_park_car_success_when_park_car_given_manager_manage_one_boy() {
        ParkingLot parkingLot = new ParkingLot(1);
        GraduateParkingLotBoy graduateParkingLotBoy = new GraduateParkingLotBoy(asList(parkingLot));
        ParkingLotManager parkingLotManager = new ParkingLotManager(asList(graduateParkingLotBoy));

        Car car = new Car();
        Receipt receipt = parkingLotManager.park(car);

        Assert.assertNotNull(receipt);
    }
}
