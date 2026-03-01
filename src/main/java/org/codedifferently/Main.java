package org.codedifferently;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        bank.addAccount(new CheckingAccount("Jordan", 1, 500, 5));
        bank.addAccount(new SavingsAccount("Jordan", 2, 1000, 0.03));
        bank.addAccount(new HighYieldSavings("Jordan", 3,
                300, 200, 0.05, 0, 6, 25));

        boolean running = true;

        while (running) {

            System.out.println("\n--- Jordan's Virtual Bank ---");
            System.out.println("1. View Accounts");
            System.out.println("2. Transfer Funds");
            System.out.println("3. Run Monthly Update");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    bank.printAllAccounts();
                    break;

                case 2:
                    System.out.print("From Account #: ");
                    int from = scanner.nextInt();

                    System.out.print("To Account #: ");
                    int to = scanner.nextInt();

                    System.out.print("Amount: ");
                    double amount = scanner.nextDouble();

                    bank.transfer(from, to, amount);
                    break;

                case 3:
                    bank.runMonthlyUpdates();
                    System.out.println("Monthly updates complete.");
                    break;

                case 4:
                    running = false;
                    System.out.println("Goodbye.");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }
}