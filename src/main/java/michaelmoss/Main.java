package michaelmoss;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // POLYMORPHISM:
        // All accounts stored as the base type BankAccount
        ArrayList<BankAccount> accounts = new ArrayList<>();

        // Different numbers than example
        accounts.add(new CheckingAccount("Jordan", "001", 620));
        accounts.add(new SavingsAccount("Jordan", "002", 1500));
        accounts.add(new YourThirdAccountType("Jordan", "003", 450));

        System.out.println("--- BEFORE MONTHLY UPDATE ---");
        for (BankAccount acc : accounts) {
            acc.printSummary();
        }

        // POLYMORPHISM IN LOOP:
        // Same method call, but each object runs its own version.
        for (BankAccount acc : accounts) {
            acc.monthlyUpdate();
        }

        System.out.println("\n--- AFTER MONTHLY UPDATE ---");
        for (BankAccount acc : accounts) {
            acc.printSummary();
        }
    }
}