package org.codedifferently;


public class SavingsAccount extends BankAccount {

    private double interestRate;

    public SavingsAccount(String owner, String accountNumber,
                          double balance, double interestRate) {
        super(owner, accountNumber, balance);
        this.interestRate = interestRate;
    }

    //Polymorphism
    @Override
    public void monthlyUpdate() {
        double interest = getBalance() * (interestRate / 100);
        deposit(interest);
        addTransaction("Interest applied: $" + interest);
    }
}
