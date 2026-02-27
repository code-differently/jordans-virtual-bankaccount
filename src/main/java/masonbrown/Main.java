package masonbrown;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {



        CheckingAccount checking = new CheckingAccount("Jordan", "1002", 800.00, 0.01);
        SavingsAccount savings = new SavingsAccount("Gordon", "1003", 200.00, 0.04);
        HighYield highYield = new HighYield("Mason", "1004", 1500.00, 0.08);


        ArrayList<BankAccount> accounts = new ArrayList<>();

        accounts.add(checking);
        accounts.add(savings);
        accounts.add(highYield);

        System.out.println("\n========== BEFORE TRANSACTIONS ==========");


        for (BankAccount account : accounts) {
            account.monthlyUpdate();
        }

        // calling withdraw and deposit methods
        checking.deposit(200);
        checking.withdraw(100);

        savings.withdraw(180);
        savings.deposit(50);

        highYield.withdraw(200);
        highYield.deposit(500);



        System.out.println("\n========== AFTER TRANSACTIONS ==========");

        //this is polymorphism. although the for loop
        // is searching bank accounts (the parent), the children can still be identified at runtime.

        for (BankAccount account : accounts) {
            account.monthlyUpdate();
        }

        System.out.println("\n========== RUNNING MONTHLY UPDATES ==========");


        for (BankAccount account : accounts) {
            account.applyMonthlyInterest();
        }

        System.out.println("\n========== FINAL ACCOUNT SUMMARIES ==========");

        for (BankAccount account : accounts) {
            account.monthlyUpdate();
        }
    }
}


