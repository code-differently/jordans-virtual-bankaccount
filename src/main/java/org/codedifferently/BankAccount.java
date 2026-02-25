package org.codedifferently;

public abstract class BankAccount {
    protected String owner;
    protected int accountNumber;
    protected double balance;

    public BankAccount(String owner, int accountNumber, double balance) {
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount){
        balance = balance + amount;
    }

    public void withdrawal(double amount){

        if(balance -amount < 0){
            System.out.println("Insufficient funds.");
        }else{
            balance = balance - amount;
        }
    }

    public void monthlyUpdate(){
        System.out.println("---Monthly Update---");
    }



}
