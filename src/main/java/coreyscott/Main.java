package coreyscott;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<BankAccount> accounts = new ArrayList<>();

        accounts.add(new CheckingAccount("Jordan", "1234", 500));
        accounts.add(new SavingsAccount("Jordan", "9876", 100));
        accounts.add(new MoneyMarketAccount("Jordan", "4567", 2000));

        System.out.println("**** BEFORE MONTHLY UPDATE ****");
        for (BankAccount account : accounts) {
            account.printSummary();
        }


        // complete transactions
        accounts.get(0).withdraw(200);
        accounts.get(0).withdraw(250);
        accounts.get(1).deposit(2000);
        accounts.get(1).deposit(1000);
        accounts.get(2).withdraw(500);
        accounts.get(2).withdraw(500);
        accounts.get(2).withdraw(200);
        accounts.get(2).withdraw(300);// this transaction exceeds account limit

        System.out.println("\n**** AFTER TRANSACTIONS ****");
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
