package org.codedifferently;

//abstraction, user/program does not have opportunity to directly interact with bank account, instead
//it is handled through specific Checking, Savings, Credit accounts
public abstract class BankAccount {

    //encapsulation, protected doubles restrict access only to children and classes in same package
    protected String owner;
    protected int accountNumber;
    protected double balance;

    public BankAccount(String owner, int accountNumber, double balance) {
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount){
        if (amount > 0) {
            System.out.println("You deposited $" + amount);
            balance = balance + amount;
        }else{
            System.out.println("You can't deposit a negative amount.");
        }

    }

    public void withdrawal(double amount, boolean fee) {
        if (fee) {
            System.out.println("A fee of $5 has been charged to your account this month, as your balance is below $100");
            balance = balance - 5;
        }else {

            if (balance - amount < 0) {
                System.out.println("You tried to withdrawal $" + amount + " but you have insufficient funds.");
            } else {
                System.out.println("You withdrew $" + amount);
                balance = balance - amount;
            }
        }
    }

    public void withdrawal(double amount) {
            if (balance - amount < 0) {
                System.out.println("You tried to withdrawal $" + amount + " but you have insufficient funds.");
            } else {
                System.out.println("You withdrew $" + amount);
                balance = balance - amount;
            }
    }

    public void monthlyUpdate(){
        System.out.println("---Monthly Update---");
    }

    public void printSummary(){};



}
