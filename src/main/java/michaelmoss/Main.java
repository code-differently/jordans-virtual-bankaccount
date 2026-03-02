package michaelmoss;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Polymorphism:
        // Different account types stored as BankAccount
        ArrayList<BankAccount> accounts = new ArrayList<>();

        accounts.add(new CheckingAccount("Michael", "CHK100", 80));
        accounts.add(new SavingsAccount("Jordan", "SAV200", 1000));
        accounts.add(new YourThirdAccountType("Coreye", "CRD300", 0));

        System.out.println("=== CURRENT ACCOUNTS ===");
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println("Account Index: " + i);
            accounts.get(i).printSummary();
        }

        // User chooses account
        System.out.print("Select account index: ");
        int index = scanner.nextInt();

        if (index < 0 || index >= accounts.size()) {
            System.out.println("Invalid account.");
            return;
        }

        BankAccount selected = accounts.get(index);

        // User chooses transaction type
        System.out.println("Choose transaction:");
        System.out.println("1 - Deposit");
        System.out.println("2 - Withdraw");
        int choice = scanner.nextInt();

        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();

        if (choice == 1) {
            selected.deposit(amount);
        } else if (choice == 2) {
            selected.withdraw(amount);
        } else {
            System.out.println("Invalid choice.");
        }

        // Show results after user transaction
        System.out.println("=== AFTER TRANSACTION ===");
        for (BankAccount acc : accounts) {
            acc.printSummary();
        }

        // Monthly update (polymorphism)
        System.out.print("Run monthly update? (yes=1 / no=0): ");
        int updateChoice = scanner.nextInt();

        if (updateChoice == 1) {
            for (BankAccount acc : accounts) {
                acc.monthlyUpdate();
            }

            System.out.println("=== AFTER MONTHLY UPDATE ===");
            for (BankAccount acc : accounts) {
                acc.printSummary();
            }
        }

        scanner.close();
    }
}