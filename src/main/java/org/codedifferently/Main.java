package org.codedifferently;


import java.util.*;
//Accounts are stored as AccountOperations.

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<AccountOperations> accounts = new ArrayList<>();

        accounts.add(new CheckingAccount("Jordan", "001", 500));
        accounts.add(new SavingsAccount("Jordan", "002", 1000, 0.02));
        accounts.add(new InvestmentAccount("Jordan", "003", 3000));

        System.out.println("Welcome to Christopher Bank of Wonders");
        System.out.println("=======================================");

        try {

            // Display accounts
            for (int i = 0; i < accounts.size(); i++) {
                System.out.println(i + " - " + accounts.get(i).getClass().getSimpleName());
            }

            System.out.println("Select account number:");
            int choice = scanner.nextInt();

            if (choice < 0 || choice >= accounts.size()) {
                System.out.println("Invalid account selection.");
                return;
            }

            AccountOperations selectedAccount = accounts.get(choice);

            System.out.println("1 - Deposit");
            System.out.println("2 - Withdraw");
            System.out.println("Choose transaction type:");
            int transactionType = scanner.nextInt();

            System.out.println("Enter amount:");
            double amount = scanner.nextDouble();

            if (transactionType == 1) {
                selectedAccount.deposit(amount);
                System.out.println("Deposit successful.");
            } else if (transactionType == 2) {
                selectedAccount.withdraw(amount);
                System.out.println("Withdrawal successful.");
            } else {
                System.out.println("Invalid transaction type.");
            }

        } catch (InputMismatchException e) {

            // Stops non-number input
            System.out.println("Invalid input. Please enter numeric values only.");

        } catch (IllegalArgumentException e) {

            // Stops  errors from account methods
            System.out.println("Transaction failed: " + e.getMessage());

        } finally {
            scanner.close();
        }

        System.out.println("\n--- BEFORE MONTHLY UPDATE ---");
        for (AccountOperations account : accounts) {
            account.printSummary();
        }

        // POLYMORPHISM happens here
        for (AccountOperations account : accounts) {
            account.monthlyUpdate();
        }

        System.out.println("\n--- AFTER MONTHLY UPDATE ---");
        for (AccountOperations account : accounts) {
            account.printSummary();
        }
    }
}