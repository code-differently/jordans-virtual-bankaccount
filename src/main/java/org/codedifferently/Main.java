package org.codedifferently;

import java.util.ArrayList;

// Defines entry point that runs banking simulation
public class Main {
    public static void main(String[] args) {

        // Creates list that stores all bank accounts
        ArrayList<BankAccount> accounts = new ArrayList<>();

        // Instantiates checking, savings, and credit accounts
        CheckingAccount checking = new CheckingAccount("Jayden", 5000.00);
        SavingsAccount savings = new SavingsAccount("Jordan", 17.00);
        CreditAccount credit = new CreditAccount("Coreye'", 1000, 3000, 0.25);

        // Processes deposits and withdrawals for checking account
        checking.depositFunds(1000.00);
        checking.withdrawFunds(5000.00);

        // Processes withdrawals and deposits for savings account
        savings.withdrawFunds(18.00);
        savings.depositFunds(3000.00);
        savings.withdrawFunds(517.00);
        savings.withdrawFunds(500.00);

        // Processes charges and payment for credit account
        credit.charge(3000);
        credit.charge(1000);
        credit.makePayment(1500);

        // Adds all accounts to accounts list
        accounts.add(checking);
        accounts.add(savings);
        accounts.add(credit);

        // Prints header before monthly updates
        System.out.println("\n--- BEFORE MONTHLY UPDATE ---");

        // Iterates through accounts, prints summary, and performs monthly updates
        for (BankAccount account : accounts) {
            account.printSummary();
            account.performMonthlyUpdate();
        }

        // Prints header after monthly updates
        System.out.println("\n--- AFTER MONTHLY UPDATE ---");

        // Iterates through accounts and prints updated summaries
        for (BankAccount account : accounts) {
            account.printSummary();
        }
    }
}