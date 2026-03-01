package bank;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        BankAccount checking = new CheckingAccount("Jordan", "001", 500.00, 500.00, 5.00);

        BankAccount savings  = new SavingsAccount("Jordan", "002", 1000.00, 0.02);

        BankAccount credit   = new CreditAccount("Jordan", "003", 300.00, 1000.00, 0.03);

        ArrayList<BankAccount> accounts = new ArrayList<>();

        accounts.add(checking);

        accounts.add(savings);

        accounts.add(credit);


        checking.withdraw(50);

        savings.deposit(200);

        credit.withdraw(100);

        System.out.println("\n--- BEFORE MONTHLY UPDATE ---");

        printAll(accounts);


        for (BankAccount acct : accounts) {

            acct.monthlyUpdate();
        }

        System.out.println("\n--- AFTER MONTHLY UPDATE ---");

        printAll(accounts);
    }

    private static void printAll(ArrayList<BankAccount> accounts) {
        for (BankAccount acct : accounts) {

            System.out.println(acct.getSummary());


        }
    }
}