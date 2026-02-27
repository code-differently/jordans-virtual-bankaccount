package org.codedifferently;
import java.util.Random;

public abstract class BankAccount {
    private String owner;
    private int accountNum;
    private double balance;

    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.accountNum = generateAccountNum();
        this.balance = balance;
    }

    public int generateAccountNum() {
        return new Random().nextInt(10000000, 99999999);
    }

    public String getOwner() {
        return this.owner;
    }

    public int getAccountNum() {
        return this.accountNum;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public abstract void performMonthlyUpdate();
    public abstract void printSummary();
}
