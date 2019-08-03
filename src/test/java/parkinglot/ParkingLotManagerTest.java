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

    @Test
    public void should_park_cars_success_when_park_car_given_manager_manage_two_boys_with_two_parkinglots_with_free_spaces_1_1() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        GraduateParkingLotBoy graduateParkingLotBoy = new GraduateParkingLotBoy(asList(parkingLot));
        SmartParkingLotBoy smartParkingLotBoy = new SmartParkingLotBoy(asList(parkingLot2));
        ParkingLotManager parkingLotManager = new ParkingLotManager(asList(graduateParkingLotBoy, smartParkingLotBoy));

        Car car = new Car();
        Receipt receipt = parkingLotManager.park(car);
        Receipt receipt2 = parkingLotManager.park(car);

        Assert.assertNotNull(receipt);
        Assert.assertNotNull(receipt2);
    }

    @Test
    public void should_park_cars_success_when_park_car_given_manager_manage_boy_with_parkinglot_without_space_and_manage_has_parkinglot_with_free_space_1() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        GraduateParkingLotBoy graduateParkingLotBoy = new GraduateParkingLotBoy(asList(parkingLot));
        graduateParkingLotBoy.park(new Car());
        ParkingLotManager parkingLotManager = new ParkingLotManager(asList(graduateParkingLotBoy), asList(parkingLot2));

        Car car = new Car();
        Receipt receipt = parkingLotManager.park(car);

        Assert.assertNotNull(receipt);
    }


    @Test
    public void should_pick_car_success_when_pick_given_parkinglot_manager_with_valid_receipt() {
        ParkingLot parkingLot = new ParkingLot(1);
        SuperParkingLotBoy superParkingLotBoy = new SuperParkingLotBoy(asList(parkingLot));
        ParkingLotManager parkingLotManager = new ParkingLotManager(asList(superParkingLotBoy));
        Car car = new Car();
        Receipt receipt = superParkingLotBoy.park(car);

        Car myCar = parkingLotManager.pickBy(receipt);
        Assert.assertSame(car, myCar);
    }
}
