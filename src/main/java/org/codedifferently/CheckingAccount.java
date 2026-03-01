package org.codedifferently;


public class CheckingAccount extends BankAccount {

    public CheckingAccount(String owner, String accountNumber, double balance) {
        super(owner, accountNumber, balance);
    }

    @Override
    public void monthlyUpdate() {
        double feeRate = 0.08;

        if (getBalance() <= 500) {
            double fee = getBalance() * feeRate;
            withdraw(fee);
            addTransaction("Low balance fee applied: $" + fee);
        } else {
            addTransaction("No monthly fee applied.");
        }
    }
}
