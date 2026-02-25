package org.codedifferently;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class BankAccount {

    private String owner;

    private static final AtomicInteger accountNumber = new AtomicInteger(1);

    private double balance;

    public BankAccount(double balance, String owner) {
        this.balance = balance;
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public AtomicInteger getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public abstract void deposits(double deposit);

    public abstract void withdraws(double withdraws);

    public abstract void monthlyFee(double withdraws);

    public abstract void bankSummary();


}
