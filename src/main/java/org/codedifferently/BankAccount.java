package org.codedifferently;

/*
 * INHERITANCE:
 * This abstract class contains shared behavior for all accounts.
 * Checking, Savings, and Investment accounts will extend this class.
 *
 * ABSTRACTION:
 * monthlyUpdate() is abstract because each account type behaves differently.
 */
public abstract class BankAccount implements AccountOperations {

    // Encapsulation
    private String owner;
    private String accountNumber;
    protected double balance;
//Constructor
    public BankAccount(String owner, String accountNumber, double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Starting Balance can't be negative.");
        }

        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be positive.");
        }
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal can't be negitive.");
        }

        if (amount > balance) {
            throw new IllegalArgumentException("no funds.");
        }

        balance -= amount;
    }

    @Override
    public abstract void monthlyUpdate();

    @Override
    public void printSummary() {
        System.out.println("Owner: " + owner);
        System.out.println("Account #: " + accountNumber);
        System.out.println("Balance: $" + String.format("%.2f", balance));
        System.out.println("===========================");
    }

    protected double getBalance() {
        return balance;
    }
    protected void setBalance(double newBalance) {
        this.balance = newBalance;
    }
}
