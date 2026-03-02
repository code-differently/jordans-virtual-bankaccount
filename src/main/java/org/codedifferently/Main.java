package org.codedifferently;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void printMonthlyReport(ArrayList<BankAccount> accounts) {
        System.out.println("\n===== MONTHLY BANK STATEMENT =====");
        for (BankAccount acc : accounts) {
            System.out.println("\n--- Account: " + acc.getClass().getSimpleName()
                    + " (" + acc.getAccountNumber() + ") ---");
            acc.printSummary();
            acc.printTransactionHistory();
        }
        System.out.println("===== END OF STATEMENT =====\n");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<>();

        // Create accounts
        accounts.add(new CheckingAccount("Alice", "001", 500));
        accounts.add(new SavingsAccount("Bob", "002", 1000));
        accounts.add(new CreditAccount("Charlie", "003", 300, 1000));

        boolean running = true;

        while (running) {
            System.out.println("\n===== Jordan's Virtual Bank =====");
            for (int i = 0; i < accounts.size(); i++) {
                System.out.println((i + 1) + ". " + accounts.get(i).getClass().getSimpleName() +
                        " (" + accounts.get(i).getAccountNumber() + ")");
            }

            System.out.println((accounts.size() + 1) + ". Run Monthly Update");
            System.out.println((accounts.size() + 2) + ". Print Monthly Statement");
            System.out.println((accounts.size() + 3) + ". Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            if (choice == accounts.size() + 3) { running = false; continue; }

            if (choice == accounts.size() + 1) { // Monthly Update
                System.out.println("\n--- BEFORE MONTHLY UPDATE ---");
                for (BankAccount acc : accounts) acc.printSummary();

                for (BankAccount acc : accounts) acc.monthlyUpdate();

                System.out.println("\n--- AFTER MONTHLY UPDATE ---");
                for (BankAccount acc : accounts) acc.printSummary();
                continue;
            }

            if (choice == accounts.size() + 2) { // Print monthly report
                printMonthlyReport(accounts);
                continue;
            }

            if (choice < 1 || choice > accounts.size()) {
                System.out.println("Invalid selection.");
                continue;
            }

            BankAccount selected = accounts.get(choice - 1);

            System.out.println("\n1. Deposit\n2. Withdraw\n3. Transfer\n4. View Summary\n5. Transaction History");
            System.out.print("Choose action: ");
            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    selected.deposit(scanner.nextDouble());
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    selected.withdraw(scanner.nextDouble());
                    break;
                case 3:
                    System.out.println("Select target account:");
                    for (int i = 0; i < accounts.size(); i++) {
                        if (i != choice - 1)
                            System.out.println((i + 1) + ". " + accounts.get(i).getAccountNumber());
                    }
                    int targetIndex = scanner.nextInt() - 1;
                    System.out.print("Enter amount to transfer: ");
                    selected.transfer(accounts.get(targetIndex), scanner.nextDouble());
                    break;
                case 4:
                    selected.printSummary();
                    break;
                case 5:
                    selected.printTransactionHistory();
                    break;
                default:
                    System.out.println("Invalid action.");
            }
        }

        scanner.close();
        System.out.println("Thank you for banking with us!");
    }
}