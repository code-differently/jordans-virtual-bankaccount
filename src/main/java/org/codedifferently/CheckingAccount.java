package org.codedifferently;

// Extends BankAccount to represents a checking account
public class CheckingAccount extends BankAccount {

    // Initializes checking account with owner and starting balance
    public CheckingAccount(String owner, double balance) {
        super(owner, balance);
    }

    // Adds specified amount to current balance
    public void depositFunds(double money) {
        this.setBalance(this.getBalance() + money);
    }

    // Retrieves current balance and processes withdrawal if sufficient funds exist
    public void withdrawFunds(double money) {
        double currentBalance = this.getBalance();
        if (currentBalance >= money) {
            // Deducts withdrawal amount from balance
            this.setBalance(currentBalance - money);
        } else {
            // Displays insufficient funds message
            System.out.println("Insufficient funds. Withdrawal cannot exceed current balance.");
        }
    }

    // Applies monthly maintenance fee when balance falls below threshold
    @Override
    public void performMonthlyUpdate() {
        double currentBalance = this.getBalance();
        if (this.getBalance() < 1500) {
            // Deducts monthly fee from balance
            this.setBalance(currentBalance - 12);
        }
    }

    // Prints formatted account summary with account number and balance
    @Override
    public void printSummary() {
        System.out.println("Checking (" + this.getAccountNum() + ") - Balance: $" + String.format("%.2f", this.getBalance()));
    }
}