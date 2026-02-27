package org.codedifferently;

// Extends BankAccount to represents a credit account
public class CreditAccount extends BankAccount {

    // Stores maximum borrowing limit
    private double creditLimit;
    // Stores monthly interest rate
    private double monthlyInterestRate;  // e.g. 0.02 (2% monthly)

    // Initializes credit account with owner, starting balance, credit limit, and interest rate
    public CreditAccount(String owner, double balance, double creditLimit, double monthlyInterestRate) {
        super(owner, balance);
        this.creditLimit = creditLimit;
        this.monthlyInterestRate = monthlyInterestRate;
    }

    // Retrieves current balance and processes charge if within credit limit
    public void charge(double amount) {
        double currentBalance = this.getBalance();
        if (currentBalance + amount <= this.creditLimit) {
            // Adds charge amount to balance
            this.setBalance(currentBalance + amount);
        } else {
            // Displays insufficient credit message
            System.out.println("Insufficient credit. Charge cannot exceed current balance.");
        }
    }

    // Applies monthly interest to outstanding balance
    public void performMonthlyUpdate() {
        this.setBalance(this.getBalance() * this.monthlyInterestRate);
    }

    // Processes payment and prevents negative balance
    public void makePayment(double amount) {
        double newBalance = this.getBalance() - amount;
        if (newBalance < 0) {
            // Resets balance to zero if overpaid
            newBalance = 0;
        }
        this.setBalance(newBalance);
    }

    // Prints formatted account summary with account number and balance
    public void printSummary() {
        System.out.println("Credit (" + this.getAccountNum() + ") - Balance: $" + String.format("%.2f", this.getBalance()));
    }
}