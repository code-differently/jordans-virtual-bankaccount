package org.codedifferently;

public class SavingsAccount extends BankAccount {
    protected double interestRate;

    public SavingsAccount(String owner, int accountNumber, double balance, double interestRate) {
        super(owner, accountNumber, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void monthlyUpdate() {
        if (balance > 0) {
            System.out.println("You have accrued " + interestRate + "% monthly interest");
            balance = balance + (balance * (interestRate/100));
        }
            //add prints

            super.monthlyUpdate();
            System.out.println("Savings (" + accountNumber + ") - Balance: " + balance);


    }
}
