package org.codedifferently;

/*
 * Savings account subclass.
 * - Adds monthly interest behavior
 */
public class SavingsAccount extends BankAccount {

    private double interestRate = 0.03; // 3% monthly interest

    public SavingsAccount(String owner, String accountNumber, double balance) {
        super(owner, accountNumber, balance);
    }

    @Override
    public void monthlyUpdate() {
        double interest = getBalance() * interestRate;
        setBalance(getBalance() + interest);
        addTransaction("Monthly Interest", interest, "Interest added");
    }

    @Override
    public void printSummary() {
        System.out.println("Savings (" + getAccountNumber() + ") - Balance: $"
                + String.format("%.2f", getBalance()));
    }
}