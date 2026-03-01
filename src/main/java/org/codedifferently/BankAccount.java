package org.codedifferently;

import java.util.ArrayList;

//Abstraction
public abstract class BankAccount {

    //Encapsulation
    private String owner;
    private String accountNumber;
    private double balance;
    private ArrayList<String> transactions;

    public BankAccount(String owner, String accountNumber, double balance) {
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactions = new ArrayList<>();

        addTransaction("Account opened with $" + balance);
    }

    // Getters
    public String getOwner() { return owner; }
    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }

    //Setter
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Record transaction
    protected void addTransaction(String message) {
        transactions.add(message);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            setBalance(getBalance() + amount);
            addTransaction("Deposited $" + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= getBalance()) {
            setBalance(getBalance() - amount);
            addTransaction("Withdrew $" + amount);
        } else {
            addTransaction("Failed withdrawal attempt of $" + amount);
        }
    }

    public abstract void monthlyUpdate();

    public void printSummary() {
        System.out.println("\nOwner: " + owner +"\nAccount Number: " + accountNumber +
                "\nTotal Transactions: " + transactions.size() + "\nCurrent Balance: $" + balance);

        System.out.println("Transaction History:");
        for (String t : transactions) {
            System.out.println("  - " + t);
        }

        System.out.println("-------------------------------------------------");
    }
}













