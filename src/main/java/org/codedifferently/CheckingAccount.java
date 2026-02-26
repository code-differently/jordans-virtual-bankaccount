package org.codedifferently;

public class CheckingAccount extends BankAccount {
    protected double previousBalance;

    public CheckingAccount(String owner, int accountNumber, double balance) {
        super(owner, accountNumber, balance);
        this.previousBalance = balance;
    }

    @Override
    public void monthlyUpdate(){

        System.out.println("Last Month: ");
        printPreviousSummary();

        super.monthlyUpdate();
        if(balance < 100 && balance > 5){
            withdrawal(5, true);
        }else if(balance < 5){
            System.out.println("Your account is at risk of being closed due to insufficient funds.");
        }

        //add prints
        printPreviousSummary();
        previousBalance = balance;

    }

    //monthly update, print out a summary of what the account is doing after it's already done
    @Override
    public void printSummary(){
        System.out.println("Checking (" + accountNumber + ") - Balance: $" + balance);
    }

    public void printPreviousSummary(){
        System.out.println("Checking (" + accountNumber + ") - Balance: $" + previousBalance);
    }


}
