package coreyscott;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<BankAccount> accounts = new ArrayList<>();

        accounts.add(new CheckingAccount("Jordan", "001", 5000));
        accounts.add(new SavingsAccount("Jordan", "002", 10000));
        accounts.add(new MoneyMarketAccount("Jordan", "003", 20000));

        System.out.println("**** BEFORE MONTHLY UPDATE ***");
        for (BankAccount account : accounts) {
            account.printSummary();
        }

        System.out.println("\n--- BEFORE TRANSACTIONS ---");
        for (BankAccount account : accounts) {
            account.printSummary();
        }


        // complete transactions
        accounts.get(0).withdraw(235);
        accounts.get(0).withdraw(1550);
        accounts.get(1).deposit(2000);
        accounts.get(1).deposit(1000);
        accounts.get(2).withdraw(570);
        accounts.get(2).withdraw(1000);
        accounts.get(2).withdraw(200);
        accounts.get(2).withdraw(300);// this transaction exceeds account limit

        System.out.println("\n--- AFTER TRANSACTIONS ---");
        for (BankAccount account : accounts) {
            account.printSummary();
        }


        // polymorphism
        for (BankAccount account : accounts) {
            account.monthlyUpdate();
        }

        System.out.println("\n**** AFTER MONTHLY UPDATE ****");
        for (BankAccount account : accounts) {
            account.printSummary();
        }

    }
}
