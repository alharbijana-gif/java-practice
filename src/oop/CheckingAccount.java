package oop;

/** Allows an overdraft up to a limit, so it overrides withdraw(). */
public class CheckingAccount extends BankAccount {
    private final double overdraftLimit;

    public CheckingAccount(String owner, double openingBalance, double overdraftLimit) {
        super(owner, openingBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) throw new IllegalArgumentException("Withdrawal must be positive");
        if (amount > balance + overdraftLimit) {
            throw new InsufficientFundsException("Exceeds overdraft limit of " + overdraftLimit);
        }
        balance -= amount;
    }
}
