package amanidrummond;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<BankAccount> accounts = new ArrayList<>();

        accounts.add(new CheckingAccount("Jordan", "001", 500.00, 500.00,
                5.00));
        accounts.add(new SavingsAccount("Jordan", "002", 1000.00, 0.02));
        accounts.add(new CreditAccount("Jordan", "003", 300.00, 500.00, 0.03));

        accounts.get(0).withdraw(50);
        accounts.get(1).deposit(25);
        accounts.get(2).withdraw(100);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== JORDAN'S VIRTUAL BANK ===");
            System.out.println("1) Print account summaries");
            System.out.println("2) Deposit");
            System.out.println("3) Withdraw");
            System.out.println("4) Run monthly update (all accounts)");
            System.out.println("5) Exit");
            System.out.println("Choose an option");

            int choice = scanner.nextInt();

            if (choice == 1) {
                printSummaries(accounts);
            } else if (choice == 2) {
                int index = pickAccount(scanner, accounts);
                System.out.println("Deposit amount: ");
                double amt = scanner.nextDouble();

                boolean ok = accounts.get(index).deposit(amt);
                System.out.println(ok ? " Deposit successful. " : "Deposit failed. ");
            } else if (choice == 3) {
                int index = pickAccount(scanner, accounts);
                System.out.println("Withdraw amount: ");
                double amt = scanner.nextDouble();

                boolean ok = accounts.get(index).withdraw(amt);
                System.out.println(ok ? " Withdrawal successful. " : "Withdrawal failed. ");
            } else if (choice == 4) {
                for (BankAccount acct: accounts) {
                    acct.monthlyUpdate();
                }
                System.out.println("Monthly update complete. ");

            } else if (choice == 5) {
                System.out.println("Goodbye!");
                break;

            } else {
                System.out.println("Invalid option. Try again. ");
            }
        }
        scanner.close();

        System.out.println("--- BEFORE MONTHLY UPDATE ---");
        printSummaries(accounts);

        for (BankAccount acct : accounts) {
            acct.monthlyUpdate();
        }

        System.out.println("\n--- AFTER MONTHLY UPDATE ---");
        printSummaries(accounts);
    }

    private static int pickAccount(Scanner scanner, ArrayList<BankAccount> accounts) {
        System.out.println("\n Pick an account: ");
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println((i + 1) + " ) " + accounts.get(i).getSummary());
        }
        System.out.println("Enter -1" + accounts.size() + ": ");
        int choice = scanner.nextInt();
        return choice -1;
    }

    private static void printSummaries(ArrayList<BankAccount> accounts) {
        for (BankAccount acct : accounts) {
            System.out.println(acct.getSummary());
        }
    }
}