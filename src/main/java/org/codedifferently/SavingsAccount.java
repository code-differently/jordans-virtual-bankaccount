package org.codedifferently;

public class SavingsAccount extends BankAccount {
    public SavingsAccount(double balance, String owner) {
        super(balance, owner);
    }

    @Override
    public void deposits(double deposit) {
        setBalance(getBalance()+deposit);

    }

    @Override
    public void withdraws(double withdraws) {


    }

    @Override
    public void monthlyFee(double withdraws) {


    }

    @Override
    public void bankSummary() {
        System.out.println("Saving " + getAccountNumber() + "- Balance " + getBalance());
    }
}

