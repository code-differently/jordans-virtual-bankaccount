package org.codedifferently;

public class SpendingAccount extends BankAccount{
    private double maxSpendingLimit;
    private double spendingLimit;

    public SpendingAccount(String ownerName, int accountNumber, double balance, double maxSpendingLimit, double spendingLimit) {
        super(ownerName, accountNumber, balance);
        this.maxSpendingLimit = maxSpendingLimit;
        this.spendingLimit = spendingLimit;
    }

    public double getmaxSpendingLimit() {
        return maxSpendingLimit;
    }

    public void setmaxSpendingLimit(double maxSpendingLimit) {
        this.maxSpendingLimit = maxSpendingLimit;
    }

    public double getSpendingLimit() {
        return spendingLimit;
    }

    public void setSpendingLimit(double spendingLimit) {
        this.spendingLimit = spendingLimit;
    }

    @Override
    public double withdrawal(double amount) {
        if (amount > getBalance()) {
            System.out.println("Transaction denied. Insufficient funds.");
            return 0;
        }

        if (amount > spendingLimit) {
            System.out.println("Spending limit reached.");
            return 0;
        }

        setBalance(getBalance()-amount);
        setSpendingLimit(getSpendingLimit()- amount);
        return amount;
    }

    @Override
    public void monthlyUpdate() {
        setSpendingLimit(getmaxSpendingLimit());
    }

    @Override
    public void displaySummary() {
        System.out.printf("Spendings (%d) - Balance: $%.2f%n", super.getAccountNumber(), super.getBalance());
    }

}
