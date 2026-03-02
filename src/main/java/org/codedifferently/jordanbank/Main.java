package org.codedifferently.jordanbank;

import java.util.ArrayList; // Import collection

public class Main {

    public static void main(String[] args) {

        // POLYMORPHISM:
        // All objects are typed as BankAccount
        BankAccount checking = new CheckingAccount("Jordan", "001", 500);
        BankAccount savings = new SavingsAccount("Jordan", "002", 1000);
        BankAccount credit = new CreditAccount("Jordan", "003", 0);

        // Store in one collection (base type reference)
        ArrayList<BankAccount> accounts = new ArrayList<>();

        accounts.add(checking);
        accounts.add(savings);
        accounts.add(credit);

        // Perform transactions
        checking.withdraw(50);
        savings.deposit(200);
        credit.withdraw(300);

        // Print BEFORE monthly update
        System.out.println("--- BEFORE MONTHLY UPDATE ---");

        // POLYMORPHIC LOOP
        for (BankAccount account : accounts) {

            // Each object uses its own version of getSummary()
            System.out.println(account.getSummary());
        }

        // Run monthly updates on ALL accounts
        for (BankAccount account : accounts) {

            // This triggers different behavior depending on object type
            account.monthlyUpdate();
        }

        // Print AFTER monthly update
        System.out.println("\n--- AFTER MONTHLY UPDATE ---");

        for (BankAccount account : accounts) {

            System.out.println(account.getSummary());
        }
    }
}