package org.codedifferently;

public class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String ownerName, int accountNumber, double balance, double interestRate) {
        super(ownerName, accountNumber, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public double withdrawal(double amount){
        //if amount was greater what's result
        if(amount > super.getBalance()){
            System.out.println("Transaction denied. Insufficient funds.");
            return 0.0;
        }
        setBalance(super.getBalance()-amount);
        return amount;
    }

    @Override
    public void monthlyUpdate() {
        double monthlyRate = interestRate / 12;
        double interest = super.getBalance() * monthlyRate;
        super.setBalance(super.getBalance() + interest);
        System.out.printf("Interest applied: $%.2f%n", interest);
    }

    @Override
    public void displaySummary() {
        System.out.printf("Savings (%d) - Balance: $%.2f%n", super.getAccountNumber(), super.getBalance());
    }
}
