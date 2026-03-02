package org.codedifferently;

//inheritance, class inherits fields and methods from bank account
public class CheckingAccount extends BankAccount {

    //encapsulation, protected doubles restrict access only to children and classes in same package
    protected double previousBalance;

    public CheckingAccount(String owner, int accountNumber, double balance) {
        super(owner, accountNumber, balance);
        this.previousBalance = balance;
    }

    //polymorphism, same method as BankAccount but different behaviors
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

    //polymorphism, same method as BankAccount but different behaviors
    //monthly update, print out a summary of what the account is doing after it's already done
    @Override
    public void printSummary(){
        System.out.println("Checking (" + accountNumber + ") - Balance: $" + balance);
    }

    public void printPreviousSummary(){
        System.out.println("Checking (" + accountNumber + ") - Balance: $" + previousBalance);
    }


}
