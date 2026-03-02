package org.codedifferently.jordanbank;

public abstract class BankAccount {
    // PRIVATE fields = ENCAPSULATION
    private String owner;          // Name of account holder
    private String accountNumber;  // Unique account number

    // Protected allows subclasses to access balance directly
    protected double balance;      // Current account balance

    // Constructor used by subclasses with super()
    public BankAccount(String owner, String accountNumber, double balance) {
        this.owner = owner;                 // Assign owner
        this.accountNumber = accountNumber; // Assign account number
        this.balance = balance;             // Assign starting balance
    }

    // Shared deposit logic INHERITED by all subclasses
    public void deposit(double amount) {
        // Validation protects data (ENCAPSULATION)
        if (amount > 0) {
            balance += amount; // Add amount to balance
        }
    }

    // Abstract method = subclasses MUST define their own withdraw logic
    // This enforces ABSTRACTION
    public abstract void withdraw(double amount);

    // Abstract monthly update each account behaves differently
    public abstract void monthlyUpdate();

    // Shared summary method used polymorphically
    public String getSummary() {
        return getClass().getSimpleName() + // Gets actual subclass name
                " (" + accountNumber + ") - Balance: $" +
                String.format("%.2f", balance); // Formats to 2 decimals
    }

    // Getter for owner controlled access = ENCAPSULATION
    public String getOwner() {
        return owner;
    }

    // Getter for account number
    public String getAccountNumber() {
        return accountNumber;
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }
}
