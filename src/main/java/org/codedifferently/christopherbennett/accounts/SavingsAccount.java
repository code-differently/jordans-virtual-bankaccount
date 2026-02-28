package org.codedifferently.christopherbennett.accounts;

import org.codedifferently.christopherbennett.data.User;
import org.codedifferently.christopherbennett.interfaces.IAccount;
import org.codedifferently.christopherbennett.abstracts.BankAccount;

public class SavingsAccount extends BankAccount implements IAccount {

    double interestGained = 0.50;

    public SavingsAccount(User accountUser, String accountName, long accountNum, double balance) {
        super(accountUser, accountName, accountNum, balance);
    }

    @Override
    public void displayMonthlyStatement() {
        System.out.println("-----------SAVINGS ACCOUNT MONTHLY STATEMENTS-------------------------");
        System.out.println();
        System.out.println("Interest gained: $" + String.format("%.2f", interestGained));
        System.out.println();
    }

}
