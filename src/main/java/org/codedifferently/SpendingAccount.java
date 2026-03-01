package org.codedifferently;
//child class of the BankAccount class
public class SpendingAccount extends BankAccount{
    //fields of a spending account
    private double maxSpendingLimit;
    private double spendingLimit;

    //constructor
    public SpendingAccount(String ownerName, int accountNumber, double balance, double maxSpendingLimit) {
        super(ownerName, accountNumber, balance);
        this.maxSpendingLimit = maxSpendingLimit;
        this.spendingLimit = maxSpendingLimit;
    }

    //getters and setters to access and modify private fields
    public double getMaxSpendingLimit() {
        return maxSpendingLimit;
    }

    public void setMaxSpendingLimit(double maxSpendingLimit) {
        this.maxSpendingLimit = maxSpendingLimit;
    }

    public double getSpendingLimit() {
        return spendingLimit;
    }

    public void setSpendingLimit(double spendingLimit) {
        this.spendingLimit = spendingLimit;
    }

    //chunk of code below are methods that override the abstract methods in the parent class
    @Override
    public void deposit(double amount){
        setBalance(getBalance() + amount);
        System.out.printf("Spending (%d) - You deposited $%.2f into your account%n", getAccountNumber(), getBalance());
    }

    @Override
    public double withdrawal(double amount) {
        if (amount > getBalance()) {
            System.out.println("Spending (" + getAccountNumber() + ") - Transaction denied. Insufficient funds.");
            return 0;
        }

        if (amount > spendingLimit) {
            System.out.println("Spending limit reached.");
            return 0;
        }

        setBalance(getBalance()-amount);
        setSpendingLimit(getSpendingLimit()- amount);
        System.out.printf("Spending (%d) - You withdrew $%.2f from your account%n", getAccountNumber(), amount);
        return amount;
    }

    @Override
    public void monthlyUpdate() {
        setSpendingLimit(getMaxSpendingLimit());
    }

    @Override
    public void displaySummary() {
        System.out.printf("Spending (%d) - Balance: $%.2f%n", getAccountNumber(), getBalance());
    }

}
