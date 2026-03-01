package org.codedifferently;
import java.util.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //array that stores BankAccount objects
        BankAccount[] bankAccounts = new BankAccount[3];
        bankAccounts[0] = new CheckingAccount("Bryant", 1111, 50.00, 100.00);
        bankAccounts[1] = new SavingsAccount("Bryant", 2222, 8000, 0.025);
        bankAccounts[2]  = new SpendingAccount("Bryant", 3333, 600.00, 1000.00);


        //displaying the account balances before the monthly update
        System.out.println("--- BEFORE MONTHLY UPDATE ---");
        bankAccounts[0].displaySummary();
        bankAccounts[1].displaySummary();
        bankAccounts[2].displaySummary();

        //updates the accounts
        bankAccounts[0].monthlyUpdate();
        bankAccounts[1].monthlyUpdate();
        bankAccounts[2].monthlyUpdate();

        System.out.println("***********************************");

        //displaying the account balances after the monthly update
        System.out.println("--- AFTER MONTHLY UPDATE ---");
        bankAccounts[0].displaySummary();
        bankAccounts[1].displaySummary();
        bankAccounts[2].displaySummary();

        //displaying how much the user withdrawals from the bank accounts
        System.out.println("***********************************");
        System.out.println("--- WITHDRAWALS ---");
        bankAccounts[0].withdrawal(20.20);
        bankAccounts[1].withdrawal(1000.20);
        bankAccounts[2].withdrawal(100.20);

        //a spending account has a spending limit so this displays what happens when the limit is reached
        System.out.println("***********************************");
        System.out.println("--- AFTER SPENDING LIMIT IS REACHED ---");
        bankAccounts[2].withdrawal(1000.20);

        //displaying how much the user deposits from the bank accounts
        System.out.println("***********************************");
        System.out.println("--- DEPOSITS ---");
        bankAccounts[0].deposit(100.00);
        bankAccounts[1].deposit(75.00);
        bankAccounts[2].deposit(25.00);

    }
}