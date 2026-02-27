package org.codedifferently;

public class CheckingAccount extends BankAccount {

    public CheckingAccount(String owner, double balance) {
        super(owner, balance);
    }

    public void depositFunds(double money) {
        this.setBalance(this.getBalance() + money);
    }

    public void withdrawFunds(double money) {
        double currentBalance = this.getBalance();
        if (currentBalance >= money) {
            this.setBalance(currentBalance - money);
        } else {
            System.out.println("Insufficient funds. Withdrawal cannot exceed current balance.");
        }
    }

    // Applies a fee of $12 if current balance is less than $12
    @Override
    public void performMonthlyUpdate() {
        double currentBalance = this.getBalance();
        if (this.getBalance() < 1500) {
             this.setBalance(currentBalance - 12);
        }
    }

    @Override
    public void printSummary() {
        System.out.println("Checking (" + this.getAccountNum() + ") - Balance: $" + String.format("%.2f", this.getBalance()));
    }
}
