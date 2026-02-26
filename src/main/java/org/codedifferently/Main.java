package org.codedifferently;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {



        BankAccount savingsAccount = new SavingsAccount(10000.00, "002", "Derwin");
        BankAccount checkingAccount = new CheckingAccount(5000.00,"001", "Derwin");
        BankAccount creditCard = new CreditCard(2000.00, "003", "Derwin", 2000);

        ArrayList<BankAccount> bankAccounts = new ArrayList<>();

        bankAccounts.add(checkingAccount);
        bankAccounts.add(savingsAccount);
        bankAccounts.add(creditCard);

        transaction(checkingAccount, savingsAccount, creditCard, bankAccounts);





    }

    public static void transaction(BankAccount checkingAccount, BankAccount savingsAccount, BankAccount creditCard, ArrayList<BankAccount> bankAccounts){
        Scanner scan = new Scanner(System.in);

        double replenish = 0.0;



        for(BankAccount b: bankAccounts){
            b.bankSummary();
        }

        do{
            System.out.println("\n1.Checking \n2.Saving \n3.Credit");
            int wdChoice = scan.nextInt();

            if(wdChoice == 1)
            {
                System.out.println("1.Deposit \n2.Withdraw ");
                int choice = scan.nextInt();

                switch (choice){

                    case 1:
                        System.out.println("Enter Deposit Amount");
                        double deposit = scan.nextDouble();
                        checkingAccount.deposits(deposit);
                        break;

                    case 2:
                        System.out.println("Enter Withdraw Amount");
                        double withdraw = scan.nextDouble();
                        checkingAccount.withdraws(withdraw);
                        break;

                    default:
                        System.out.println("Not Valid");
                        break;
                }

            }
            else if (wdChoice == 2)
            {
                System.out.println("1.Deposit \n2.Withdraw ");
                int choice = scan.nextInt();

                switch (choice){

                    case 1:
                        System.out.println("Enter Deposit Amount");
                        double deposit = scan.nextDouble();
                        savingsAccount.deposits(deposit);
                        break;

                    case 2:
                        System.out.println("Enter Withdraw Amount");
                        double withdraw = scan.nextDouble();
                        savingsAccount.withdraws(withdraw);
                        break;

                    default:
                        System.out.println("Not Valid");
                        break;
                }

            } else if (wdChoice == 3) {
                System.out.println("1.Deposit \n2.Withdraw ");
                int choice = scan.nextInt();

                switch (choice){

                    case 1:
                        System.out.println("Enter Deposit Amount");
                        double deposit = scan.nextDouble();
                        creditCard.deposits(deposit);
                        checkingAccount.setBalance(checkingAccount.getBalance()-deposit);
                        break;

                    case 2:
                        System.out.println("Enter Withdraw Amount");
                        double withdraw = scan.nextDouble();
                        replenish += withdraw;
                        creditCard.withdraws(withdraw);

                        break;

                    default:
                        System.out.println("Not Valid");
                        break;
                }


            } else {
                System.out.println("Not Valid");

            }


            for(BankAccount b: bankAccounts){
                b.bankSummary();
            }

            System.out.println("\nHas it been a month? y/n");
            String choice = scan.next();

            if(choice.equals("y")){
                monthlyUpdate(checkingAccount, savingsAccount, creditCard, bankAccounts, replenish);

            }

        }while(true);

    }


    public static void monthlyUpdate(BankAccount checkingAccount, BankAccount savingsAccount, BankAccount creditCard, ArrayList<BankAccount> bankAccounts, double replenish){

        checkingAccount.monthlyFee();
        savingsAccount.monthlyFee();
        checkingAccount.setBalance(checkingAccount.getBalance() - replenish);
        creditCard.setBalance(creditCard.getBalance() + replenish);
        creditCard.monthlyFee();


        for(BankAccount b: bankAccounts){
            b.bankSummary();
        }


    }
}