package parkinglot.exceptions;

public class NoSpaceInParkingLotException extends RuntimeException {
    public NoSpaceInParkingLotException(String message) {
        super(message);
    }
}
