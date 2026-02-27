package org.codedifferently;
import java.util.Random;

// Defines abstract base class that represents a generic bank account
public abstract class BankAccount {

    // Stores account owner's name
    private String owner;
    // Stores unique account number
    private int accountNum;
    // Stores current account balance
    private double balance;

    // Initializes bank account with owner and starting balance
    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.accountNum = generateAccountNum();
        this.balance = balance;
    }

    // Generates random eight-digit account number
    public int generateAccountNum() {
        return new Random().nextInt(10000000, 99999999);
    }

    // Returns account owner's name
    public String getOwner() {
        return this.owner;
    }

    // Returns account number
    public int getAccountNum() {
        return this.accountNum;
    }

    // Returns current account balance
    public double getBalance() {
        return this.balance;
    }

    // Updates account balance
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Enforces monthly update behavior in subclasses
    public abstract void performMonthlyUpdate();

    // Enforces account summary printing in subclasses
    public abstract void printSummary();
}