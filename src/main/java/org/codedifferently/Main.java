package org.codedifferently;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<BankAccount> accounts = new ArrayList<>();

        accounts.add(new CheckingAccount("Bridgette", "CH457", 6000));
        accounts.add(new SavingsAccount("Scott", "SAV082", 15000, 8));
        accounts.add(new GrowthAccount("Ellis", "GRO983", 3000, 4));

        System.out.println("--- BEFORE MONTHLY UPDATE ---");
        for (BankAccount account : accounts) {
            account.printSummary();
        }

        accounts.get(0).withdraw(4500);
        accounts.get(1).deposit(20000);
        accounts.get(2).withdraw(1050);

        for (BankAccount account : accounts) {
            account.monthlyUpdate();
        }

        System.out.println("\n--- AFTER MONTHLY UPDATE ---");
        for (BankAccount acc : accounts) {
            acc.printSummary();
        }
    }
}
