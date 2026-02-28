package org.codedifferently.christopherbennett.accounts;

import org.codedifferently.christopherbennett.interfaces.IAccount;
import org.codedifferently.christopherbennett.abstracts.BankAccount;
import org.codedifferently.christopherbennett.data.User;

public class CheckingAccount extends BankAccount implements IAccount {

    private double lowBalanceRequirement = 50;
    private final double monthlyFee = 5;

    public CheckingAccount(User accountUser, String accountName, long accountNum, double balance) {
        super(accountUser, accountName, accountNum, balance);
    }

    boolean checkForFees() {
        if(balance <= lowBalanceRequirement) {
            balance += monthlyFee;
            return  true;
        }
        return false;
    }

    @Override
    public void displayMonthlyStatement() {
        System.out.println("-----------CHECKING ACCOUNT MONTHLY STATEMENTS------------------------");
        System.out.println();

        if(checkForFees()) {
            System.out.println("Your balance is low!!! A fee of " + String.format("%2.f",monthlyFee) +  " will be applied!");
        }
        else {
            System.out.println("Your current checking account balance is high enough for no fees to be applied!");
        }
        System.out.println();
    }
}
