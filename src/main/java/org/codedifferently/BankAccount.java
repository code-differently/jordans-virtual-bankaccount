package org.codedifferently;

public abstract class BankAccount {

    private String owner;
    private String accountNumber;
    protected double balance;

    public BankAccount(String owner, String accountNumber, double initialBalance) {
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public BankAccount(String accountNumber, double balance) {
    }

    // Encapsulation (getters)
    public String getOwner() {
        return owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    // Common behavior
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Abstract methods (forces subclasses to define behavior)
    public abstract void withdraw(double amount);

    public abstract void monthlyUpdate();

    public void printSummary() {
        System.out.println("Owner: " + owner);
        System.out.println("Account #: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }
}