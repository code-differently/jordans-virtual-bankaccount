package org.codedifferently;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        bank.addAccount(new CheckingAccount("Jordan", 1032107, 700, 5));
        bank.addAccount(new SavingsAccount("Jordan", 1032101, 5000, 0.03));
        bank.addAccount(new HighYieldSavings("Jordan", 1032109,
                12000, 10000, 0.05, 0, 1, 25));

        boolean running = true;

        while (running) {

            System.out.println("\n--- Jordan's Virtual Bank ---");
            System.out.println("1. View Accounts");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Run Monthly Update");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    bank.printAllAccounts();
                    break;

                case 2:
                    System.out.print("Account #: ");
                    int depAcc = scanner.nextInt();

                    System.out.print("Amount: ");
                    double depAmount = scanner.nextDouble();

                    bank.deposit(depAcc, depAmount);
                    break;

                case 3:
                    System.out.print("Account #: ");
                    int withAcc = scanner.nextInt();

                    System.out.print("Amount: ");
                    double withAmount = scanner.nextDouble();

                    bank.withdraw(withAcc, withAmount);
                    break;

                case 4:
                    System.out.print("From Account #: ");
                    int from = scanner.nextInt();

                    System.out.print("To Account #: ");
                    int to = scanner.nextInt();

                    System.out.print("Amount: ");
                    double amount = scanner.nextDouble();

                    bank.transfer(from, to, amount);
                    break;

                case 5:
                    bank.runMonthlyUpdates();
                    System.out.println("Monthly updates complete.");
                    break;

                case 6:
                    System.out.println("Goodbye.");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option.");
            }


        }
        scanner.close();
    }

}