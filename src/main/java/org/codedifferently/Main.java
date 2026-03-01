package org.codedifferently;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        Customer new1 = Customer.createNewCustomer();
        CheckingAccount chkAcct = new CheckingAccount(new1, new1.getAcctNumber(), 0);
        SavingsAccount savAcct = new SavingsAccount(new1, new1.getAcctNumber(), 0);
        BrokerageAccount broAcct = new BrokerageAccount(new1, new1.getAcctNumber(), 0);

        //ArrayList<BankAccount> bankAccounts = new ArrayList<>();
        new1.bankAccounts.add(chkAcct);
        new1.bankAccounts.add(savAcct);
        new1.bankAccounts.add(broAcct);

        boolean bankOpen = true;
        while (bankOpen) {
        System.out.println("==========================================");
        System.out.println("Please review menu and make a selection.");
        System.out.println("1. View Accounts.");
        System.out.println("2. Deposit Funds.");
        System.out.println("3. Withdraw Funds.");
        System.out.println("4. View Monthly Statement.");
        System.out.println("5. Logout.");
            int menuSelection = sc.nextInt();
            switch (menuSelection) {
                case 1:
                    new1.printAccountSummaries();
                    continue;
                case 2:
                    String depositAcctType = new1.selectAccount();
                    new1.depositFunds(new1.getAcctNumber(), depositAcctType);
                    break;
                case 3:
                    String withdrawAcctType = new1.selectAccount();
                    new1.withdrawFunds(new1.getAcctNumber(), withdrawAcctType);
                    break;
                case 5:
                    bankOpen=false;
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }

        }
    }
}