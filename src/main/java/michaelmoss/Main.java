package michaelmoss;

import java.util.ArrayList;

public class Main {


        public static void main(String[] args) {

            // Polymorphism:
            // Different account types stored as BankAccount
            ArrayList<BankAccount> accounts = new ArrayList<>();

            accounts.add(new CheckingAccount("Michael", "CHK100", 80));
            accounts.add(new SavingsAccount("Jordan", "SAV200", 1000));
            accounts.add(new YourThirdAccountType("Coreye", "CRD300", 0));

            System.out.println("=== BEFORE TRANSACTIONS ===");
            for (BankAccount acc : accounts) {
                acc.printSummary();
            }

            // Transactions
            accounts.get(0).deposit(50);
            accounts.get(1).withdraw(200);
            accounts.get(2).withdraw(300);

            System.out.println("=== AFTER TRANSACTIONS ===");
            for (BankAccount acc : accounts) {
                acc.printSummary();
            }

            // Polymorphism:
            // Same method call, different behavior depending on account type
            for (BankAccount acc : accounts) {
                acc.monthlyUpdate();
            }

            System.out.println("=== AFTER MONTHLY UPDATE ===");
            for (BankAccount acc : accounts) {
                acc.printSummary();
            }
        }
    }

