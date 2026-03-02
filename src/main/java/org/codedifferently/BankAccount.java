package org.codedifferently;
/*All accounts must:

Have an owner
Have an account number
Have a balance
Support deposits
Support withdrawals
Support a monthly update
Be able to print a summary*/

// ABSTRACTION:
// This abstract class defines what ALL accounts must be able to do,
// but does NOT define exactly how monthlyUpdate() works.
// Subclasses must implement that behavior.

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class BankAccount {

    // Encapsulation: private fields to protect internal state
    private String owner;
    private String accountNumber;
    private double balance;
    private ArrayList<Transaction> transactions;

    // Constructor
    public BankAccount(String owner, String accountNumber, double balance) {
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactions = new ArrayList<>();
        addTransaction("Account Opened", balance, "Initial balance");
    }

    // Getters
    public String getOwner() { return owner; }
    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }

    // Encapsulated balance modification
    protected void setBalance(double balance) { this.balance = balance; }

    // Record a transaction
    protected void addTransaction(String type, double amount, String description) {
        transactions.add(new Transaction(type, amount, description, balance));
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            setBalance(balance + amount);
            addTransaction("Deposit", amount, "Deposit to account");
        }
    }

    // Withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            setBalance(balance - amount);
            addTransaction("Withdrawal", amount, "Withdraw from account");
        }
    }

    // Transfer to another account
    public void transfer(BankAccount target, double amount) {
        if (amount > 0 && amount <= balance) {
            withdraw(amount);
            target.deposit(amount);
            addTransaction("Transfer Out", amount, "To account " + target.getAccountNumber());
            target.addTransaction("Transfer In", amount, "From account " + this.accountNumber);
        }
    }

    // Print transaction history
    public void printTransactionHistory() {
        System.out.println("\nTransaction History for Account " + accountNumber);
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }

    // Abstract method: must be implemented by subclasses
    public abstract void monthlyUpdate();

    // Abstract method: print account summary
    public abstract void printSummary();
}