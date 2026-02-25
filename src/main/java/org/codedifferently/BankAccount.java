package org.codedifferently;

public abstract class BankAccount {
    private String owner;
    private String accountNum;
    private double balance;

    public abstract void depositFunds();
    public abstract void withdrawFunds();
    public abstract void getMonthlyUpdate();
    public abstract void printSummary();
}
