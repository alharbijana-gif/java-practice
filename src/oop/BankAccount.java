package oop;

/** Base account: encapsulated balance, validated deposits and withdrawals. */
public class BankAccount {
    private final String owner;
    protected double balance;

    public BankAccount(String owner, double openingBalance) {
        if (openingBalance < 0) throw new IllegalArgumentException("Opening balance cannot be negative");
        this.owner = owner;
        this.balance = openingBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit must be positive");
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) throw new IllegalArgumentException("Withdrawal must be positive");
        if (amount > balance) throw new InsufficientFundsException("Balance " + balance + " is less than " + amount);
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return String.format("%s: %s, balance=%.2f", getClass().getSimpleName(), owner, balance);
    }
}
