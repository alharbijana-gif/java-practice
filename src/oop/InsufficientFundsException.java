package oop;

/** Checked exception thrown when a withdrawal is larger than the available balance. */
public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
