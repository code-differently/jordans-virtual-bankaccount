package org.codedifferently.christopherbennett;

import org.codedifferently.christopherbennett.accounts.SavingsAccount;
import org.codedifferently.christopherbennett.accounts.CheckingAccount;
import org.codedifferently.christopherbennett.accounts.CreditAccount;
import org.codedifferently.christopherbennett.data.User;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Create new User
        User userJordan = new User("jordan", "jeldridge@gmail.com", "3025552111");

        //Create at least one of each account type
        CheckingAccount checkingAccount = new CheckingAccount(userJordan, "Checking", 11113440923131L, 2000);
        SavingsAccount savingsAccount = new SavingsAccount(userJordan, "Savings", 2212123345919191L, 1000);
        CreditAccount creditAccount = new CreditAccount(userJordan, "Credit", 11121903091039919L, 500);


        //Print account summaries before updates
        checkingAccount.printSummary();
        savingsAccount.printSummary();
        creditAccount.printSummary();

        System.out.println();
        System.out.println("BEFORE MONTHLY UPDATES AND DEPOSITS:");
        System.out.println();

        //Perform multiple transactions.
        checkingAccount.makeDeposit(40);

        savingsAccount.makeDeposit(80);
        checkingAccount.makeWithdrawal(100);
        savingsAccount.makeDeposit(200);

        creditAccount.makeDeposit(180);

        //Run monthly updates on all accounts.
        checkingAccount.displayMonthlyStatement();
        savingsAccount.displayMonthlyStatement();
        creditAccount.displayMonthlyStatement();


        System.out.println("---------------------------------------------");
        System.out.println();
        System.out.println("AFTER MONTHLY UPDATES AND DEPOSITS:");
        System.out.println();

        //Print account summaries before and after updates.
        checkingAccount.printSummary();
        savingsAccount.printSummary();
        creditAccount.printSummary();


    }
}