package org.codedifferently;

import java.util.Random;

public class BrokerageAccount extends BankAccount {
    Random r = new Random();
    double dailyRateOfReturn = r.nextDouble(-10, 10);
    String acctType = "Brokerage Account";

    public BrokerageAccount(Customer person, int acctNumber, double acctBalance) {
        super(person, acctNumber, acctBalance);
    }

    public BrokerageAccount() {

    }

    @Override
    public void depositFunds(int acct, String acctType) {
        super.depositFunds(acct, acctType);
    }

    @Override
    public void withdrawFunds(int acctNum, String acctType) {
        super.withdrawFunds(acctNum, acctType);
    }

    @Override
    public String getAcctType() {
        return acctType;
    }

    @Override
    public void printSummary() {

    }

}

