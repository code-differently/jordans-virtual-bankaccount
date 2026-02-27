package org.codedifferently;

public class CreditAccount extends BankAccount {

    private double creditLimit;
    private double monthlyInterestRate;  // e.g. 0.02 (2% monthly)
    private double minimumPaymentRate;   // e.g. 0.02 (2%)
    private double lateFee;

    public CreditAccount(String owner, double balance, double creditLimit, double monthlyInterestRate) {
        super(owner, balance);
        this.creditLimit = creditLimit;
        this.monthlyInterestRate = monthlyInterestRate;
        this.minimumPaymentRate = 0.02;
        this.lateFee = 35.00;
    }

    public void charge(double amount) {
        double currentBalance = this.getBalance();
        if (currentBalance + amount <= this.creditLimit) {
            this.setBalance(currentBalance + amount);
        } else {
            System.out.println("Insufficient credit. Charge cannot exceed current balance.");
        }
    }

    public void performMonthlyUpdate() {
        this.setBalance(this.getBalance() * this.monthlyInterestRate);
    }

    public void makePayment(double amount) {
        double newBalance = this.getBalance() - amount;
        if (newBalance < 0) {
            newBalance = 0;
        }
        this.setBalance(newBalance);
    }

    public double calculateMinimumPayment() {
        return this.getBalance() * this.minimumPaymentRate;
    }

    public void printSummary() {
        System.out.println("Credit (" + this.getAccountNum() + ") - Balance: $" + String.format("%.2f", this.getBalance())); ;
    }
}
