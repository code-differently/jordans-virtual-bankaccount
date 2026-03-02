package org.codedifferently;
//Allows deposits
//
//Allows withdrawals (cannot withdraw more than balance)
//
//Monthly update:
//
//Apply a fee if balance is below a certain amount


public class CheckingAccount extends BankAccount {

    private double monthlyFee = 5.00;

    public CheckingAccount(String owner, String accountNumber, double balance) {
        super(owner, accountNumber, balance);
    }

    @Override
    public void monthlyUpdate() {
        withdraw(monthlyFee);
        addTransaction("Monthly Fee", monthlyFee, "Maintenance fee");
    }

    @Override
    public void printSummary() {
        System.out.println("Checking (" + getAccountNumber() + ") - Balance: $"
                + String.format("%.2f", getBalance()));
    }
}