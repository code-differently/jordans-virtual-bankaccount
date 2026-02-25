package org.codedifferently;
import java.util.Random;

public abstract class BankAccount {
    private String owner;
    private String accountNum;
    private double balance;

    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.accountNum = generateAccountNum(owner);
        this.balance = balance;
    }

    public String generateAccountNum(String owner) {
        if (owner.length() <= 3) {
            return owner.toUpperCase() + "-" + new Random().nextInt(1000, 999999);
        } else {
            return owner.substring(0, 3).toUpperCase() + "-" + new Random().nextInt(1000, 999999);
        }
    }

    public String getOwner() {
        return owner;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public double getBalance() {
        return balance;
    }

    public abstract void depositFunds();
    public abstract void withdrawFunds();
    public abstract void getMonthlyUpdate();
    public abstract void printSummary();
}
