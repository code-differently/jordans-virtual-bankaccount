package org.codedifferently;

public class SavingsAccount extends BankAccount {
    protected double interestRate;
    protected double previousBalance;


    public SavingsAccount(String owner, int accountNumber, double balance, double interestRate) {
        super(owner, accountNumber, balance);
        this.interestRate = interestRate;
        this.previousBalance = balance;
    }

    @Override
    public void monthlyUpdate() {

        System.out.println("Last Month: ");
        printPreviousSummary();

        //for this implementation, I accrue the interest on a monthly basis based on the balance from last month
        //new deposits/withdrawals are not considered for interest until the following month


        if (previousBalance > 0) {
            System.out.println("You have accrued " + interestRate + "% monthly interest or $" + (previousBalance * interestRate/100));
            balance = balance + (previousBalance * (interestRate/100));
        }

        super.monthlyUpdate();
            //add prints

        printSummary();
        previousBalance = balance;



    }

    @Override
    public void printSummary(){
        System.out.println("Savings (" + accountNumber + ") - Balance: $" + balance);
    }

    public void printPreviousSummary(){
        System.out.println("Savings (" + accountNumber + ") - Balance: $" + previousBalance);
    }
}
