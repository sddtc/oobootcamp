package parkinglot.beta.exceptions;

public class InvalidReceiptException extends RuntimeException {
    public InvalidReceiptException(String message) {
        super(message);
    }
}
