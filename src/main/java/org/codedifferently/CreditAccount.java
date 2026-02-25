package org.codedifferently;
//need to debug
public class CreditAccount extends BankAccount {
    double interestRate;
    double minimumPayment;
    double maximumBalance;
    double monthlyBalance;

    public CreditAccount(String owner, int accountNumber, double balance, double interestRate, double maximumBalance) {
        super(owner, accountNumber, balance);
        this.interestRate = interestRate;
        this.maximumBalance = maximumBalance;
        this.monthlyBalance = 0;
    }

    @Override
    public void deposit(double amount){
        balance = balance - amount;
        if (minimumPayment - amount < 0){
            minimumPayment = 0;
        }
        minimumPayment = minimumPayment - amount;
        monthlyBalance = monthlyBalance - amount;
    }

    @Override
    public void withdrawal(double amount){

        if(balance + amount >= maximumBalance){
            System.out.println("Max Balance.");
        }else{
            balance = balance + amount;
        }
    }

    @Override
    public void monthlyUpdate() {
        // a billing cycle

        System.out.println("Your balance for this month is: " + monthlyBalance);
        System.out.println("You outstanding balance is: " + balance);
        System.out.println("Your minimum payment is: " + minimumPayment);

        if (monthlyBalance > 0) {
            if (minimumPayment > 0) {
                //charge max interest (30%)
                System.out.println("You failed to pay the minimum payment");
                balance = balance + (balance * .30);

                minimumPayment = minimumPayment + (balance/10);


            } else {
                //charge normal interest
                balance = balance + (balance * (interestRate / 100));
                minimumPayment = (balance / 10);
            }


            monthlyBalance = balance;
        }else{
            monthlyBalance = balance;
        }

    }

}
