package org.codedifferently;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayList<BankAccount> accounts = new ArrayList<>();
        CheckingAccount checking = new CheckingAccount("Jayden", 5000.00);
        SavingsAccount savings = new SavingsAccount("Jordan", 17.00);
        CreditAccount credit = new CreditAccount("Coreye'", 1000, 3000, 0.25);

        checking.depositFunds(1000.00);
        checking.withdrawFunds(5000.00);

        savings.withdrawFunds(18.00);
        savings.depositFunds(3000.00);
        savings.withdrawFunds(517.00);
        savings.withdrawFunds(500.00);

        credit.charge(3000);
        credit.charge(1000);
        credit.makePayment(1500);

        accounts.add(checking);
        accounts.add(savings);
        accounts.add(credit);

        System.out.println("\n--- BEFORE MONTHLY UPDATE ---");

        for (BankAccount account : accounts) {
            account.printSummary();
            account.performMonthlyUpdate();
        }

        System.out.println("\n--- AFTER MONTHLY UPDATE ---");
        for (BankAccount account : accounts) {
            account.printSummary();
        }
    }
}