package org.codedifferently;


public abstract class BankAccount {

    private final String owner;

    private final String id;

    private double balance;

    public BankAccount(double balance, String id, String owner) {
        this.balance = balance;
        this.id = id;
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public String getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public abstract void deposits(double deposit);

    public abstract void withdraws(double withdraws);

    public abstract void monthlyFee();

    public abstract void bankSummary();

//
}
