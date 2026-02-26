package org.codedifferently;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
      BankAccount checking = new CheckingAccount("Jordon", 002, 0);
      BankAccount savings = new SavingsAccount("Jordon", 003, 0, 1);
   //   BankAccount credit = new CreditAccount("Jordon", 003, 0, 4, 1000);
      ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();

      accounts.add(checking);
      accounts.add(savings);
   //   accounts.add(savings);
  //    accounts.add(credit);

      checking.monthlyUpdate();
     // savings.monthlyUpdate();
   //   credit.monthlyUpdate();

      checking.deposit(10000);
     // savings.deposit(10000);
  //    credit.withdrawal(500);

      checking.monthlyUpdate();
    //  savings.monthlyUpdate();
   //   credit.monthlyUpdate();

      checking.deposit(10000);
    //  savings.deposit(10000);
    //  checking.withdrawal(1000);
    //  savings.withdrawal(1000);
    //  credit.deposit(400);

      checking.monthlyUpdate();
    //  savings.monthlyUpdate();
   //   credit.monthlyUpdate();

      checking.withdrawal(21000);
      checking.withdrawal(19999);
      checking.monthlyUpdate();
      checking.deposit(13);
      checking.monthlyUpdate();

      savings.monthlyUpdate();
      savings.deposit(10000);
      savings.monthlyUpdate();
      savings.deposit(10000);
      savings.withdrawal(1000);
      savings.monthlyUpdate();
      savings.monthlyUpdate();




      //  savings.monthlyUpdate();
    //  checking.deposit(5);
    //  checking.monthlyUpdate();
    //  savings.monthlyUpdate();

  //    credit.monthlyUpdate();

  //    credit.deposit(5);
   //   credit.monthlyUpdate();

    }
}