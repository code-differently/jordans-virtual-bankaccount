package org.codedifferently.christopherbennett.abstracts;

import org.codedifferently.christopherbennett.data.User;
import org.codedifferently.christopherbennett.interfaces.IAccount;

public abstract class BankAccount implements IAccount {

    protected User accountUser;
    protected String accountName;
    protected long accountNum;
    protected double balance;

    public BankAccount(User accountUser, String accountName, long accountNum, double balance) {
        this.accountUser = accountUser;
        this.accountName = accountName;
        this.accountNum = accountNum;
        this.balance = balance;
    }

    //method monthly update, summary of what
    //account is doing, after a month
    public void makeDeposit(double amount) {
        balance += amount;
    }

    public void makeWithdrawal(double amount) {
        double diff = balance - amount;
        if(diff < 0) {
            System.out.println("Insufficient funds required to make Withdrawal!");
            return;
        }
        balance -= amount;
    }

    public void printSummary() {
        System.out.println("---------------------------------------------");
        System.out.println(accountUser.getName().toUpperCase() + "'S "
                + accountName.toUpperCase() + " ACCOUNT");
        System.out.println("---------------------------------------------");
        System.out.println();
        System.out.println("Account Number: " + accountNum);
        System.out.println("Balance: $" + String.format("%.2f", balance));

        System.out.println();
        System.out.println();

        System.out.println("---------------------------------------------");
        //System.out.println("Find the light, go to a field where u have some interest, some care in, and find a prolbem to solve.");
    }

    public abstract void displayMonthlyStatement();

}
