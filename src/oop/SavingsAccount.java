package oop;

/** Adds interest on top of the base account. */
public class SavingsAccount extends BankAccount {
    private final double interestRate; // e.g. 0.03 = 3%

    public SavingsAccount(String owner, double openingBalance, double interestRate) {
        super(owner, openingBalance);
        this.interestRate = interestRate;
    }

    public void addInterest() {
        balance += balance * interestRate;
    }
}
