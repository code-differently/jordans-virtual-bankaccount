package org.codedifferently.christopherbennett.accounts;

import org.codedifferently.christopherbennett.data.User;
import org.codedifferently.christopherbennett.interfaces.IAccount;
import org.codedifferently.christopherbennett.abstracts.BankAccount;

public class CreditAccount extends BankAccount implements IAccount {

    public CreditAccount(User accountUser, String accountName, long accountNum, double balance) {
        super(accountUser, accountName, accountNum, balance);
    }

    @Override
    public void displayMonthlyStatement() {
        System.out.println("-----------CREDIT ACCOUNT MONTHLY STATEMENTS--------------------------");
        System.out.println();
        System.out.println("MONEY YOU OWE: $" + String.format("%.2f",balance));
        System.out.println();
    }

}
