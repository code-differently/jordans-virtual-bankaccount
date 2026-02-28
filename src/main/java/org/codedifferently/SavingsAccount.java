package org.codedifferently;

public class SavingsAccount extends BaseAccount {
    private double interestRate;
    public SavingsAccount(String owner, int accountNumber, double accountBalance, double interestRate){
        super(owner, accountNumber, accountBalance);
        this.interestRate= interestRate;
    }

    @Override
    public void makeWithdrawal(double amount){
        adjustBalance(-amount);
    }

    @Override
    public void makeDeposit(double amount){
        adjustBalance(amount);
    }


    public void monthlyUpdate() {
double monthlyInterest = getBalance() * (interestRate/12);
   adjustBalance(monthlyInterest);
    }
}
