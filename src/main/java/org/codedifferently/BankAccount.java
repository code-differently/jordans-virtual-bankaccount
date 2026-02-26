package org.codedifferently;

public abstract class BankAccount {
    private String ownerName;
    private int accountNumber;
    private double balance;

    public BankAccount(String ownerName, int accountNumber, double balance) {
        this.ownerName = ownerName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

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

    public void deposit(double amount){
        setBalance(getBalance() + amount);
    }
    public abstract double withdrawal(double amount);
    public abstract void monthlyUpdate();
    public abstract void displaySummary();

}
