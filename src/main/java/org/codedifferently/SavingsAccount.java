package org.codedifferently;

public class SavingsAccount extends BankAccount{
    protected double interestRate;
    protected double interestEarned;
    String acctType = "Savings Account";

    public SavingsAccount(Customer person, int acctNumber, double acctBalance) {
        super(person, acctNumber, acctBalance);
    }

    @Override
    public void withdrawFunds(int acctNum, String acctType) {
        super.withdrawFunds(acctNum, acctType);
    }

    @Override
    public void depositFunds(int acct, String acctType) {
        super.depositFunds(acct, acctType);
    }

    public String getAcctType() {
        return acctType;
    }

    public void setAcctType(String acctType) {
        this.acctType = acctType;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getInterestEarned() {
        return interestEarned;
    }

    public void setInterestEarned(double interestEarned) {
        this.interestEarned = interestEarned;
    }


}
