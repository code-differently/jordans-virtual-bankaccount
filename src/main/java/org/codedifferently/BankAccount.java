package org.codedifferently;

//abstract class that represents an outline for what a bank account should look like
public abstract class BankAccount {
    //private fields that should only be accessed or modified with getters and setters
    private String ownerName;
    private int accountNumber;
    private double balance;

    //constructor
    public BankAccount(String ownerName, int accountNumber, double balance) {
        this.ownerName = ownerName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    //getters and setters to access and modify private fields
    public String getOwnerName() {
        return ownerName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    //below are abstract methods that have different behavior based on the subclass that is using them

    //deposits money into bank account
    public abstract void deposit(double amount);
    //withdrawls money from the bank account
    public abstract double withdrawal(double amount);
    //updates the bank accounts. The update varies on the type of bank account that they are
    public abstract void monthlyUpdate();
    //displays the details of a bank account
    public abstract void displaySummary();

}
