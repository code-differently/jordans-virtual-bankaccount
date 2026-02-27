package jamesbarclay;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // POLYMORPHISM: one list holds different account types
        ArrayList<BankAccount> accounts = new ArrayList<>();

        // James Barclay's accounts
        accounts.add(new CheckingAccount("James Kollilon Barclay III", "001", 5000));
        accounts.add(new SavingAccount("James Kollilon Barclay III", "002", 100000));
        accounts.add(new SpendingAccount("James Kollilon Barclay III", "003", 3000, 400));

        System.out.println("--- BEFORE MONTHLY UPDATE ---");
        for (BankAccount acc : accounts) {
            acc.printSummary();
        }

        // some transactions
        accounts.get(0).withdraw(4500);
        accounts.get(1).deposit(20000);
        accounts.get(2).withdraw(1050);

        // monthly updates
        for (BankAccount acc : accounts) {
            acc.monthlyUpdate();
        }

        System.out.println("\n--- AFTER MONTHLY UPDATE ---");
        for (BankAccount acc : accounts) {
            acc.printSummary();
        }
    }
}