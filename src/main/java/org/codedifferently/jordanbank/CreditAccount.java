package org.codedifferently.jordanbank;

public class CreditAccount extends BankAccount{

    // Unique fields for credit accounts
    private double creditLimit = 1000;  // Maximum allowed debt
    private double interestRate = 0.03; // 3% interest on debt

    // Constructor
    public CreditAccount(String owner, String accountNumber, double balance) {
        super(owner, accountNumber, balance);
    }

    // Withdraw means borrowing money
    @Override
    public void withdraw(double amount) {

        // Allow balance to go negative up to credit limit
        if (amount > 0 && balance - amount >= -creditLimit) {
            balance -= amount;
        }
    }

    // Monthly update adds interest if balance is negative
    @Override
    public void monthlyUpdate() {

        // Only apply interest if in debt
        if (balance < 0) {

            // Interest increases debt
            balance += balance * interestRate;
        }
    }
}
