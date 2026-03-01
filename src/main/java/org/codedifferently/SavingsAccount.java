package org.codedifferently;
//child class of the BankAccount class
public class SavingsAccount extends BankAccount {
    //fields of a savings account
    private double interestRate;
    private boolean accountUpdated;

    //constructor
    public SavingsAccount(String ownerName, int accountNumber, double balance, double interestRate) {
        super(ownerName, accountNumber, balance);
        this.interestRate = interestRate;
        accountUpdated = false;
    }

    //getter and setter to access and modify private fields
    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    //chunk of code below are methods that override the abstract methods in the parent class
    @Override
    public double withdrawal(double amount){
        //if amount was greater what's result
        if(amount > super.getBalance()){
            System.out.println("Savings (" + getAccountNumber() + ") - Transaction denied. Insufficient funds.");
            return 0.0;
        }
        setBalance(super.getBalance()-amount);
        System.out.printf("Savings (%d) - You withdrew $%.2f from your account%n", getAccountNumber(), amount);
        return amount;
    }

    @Override
    public void deposit(double amount){
        setBalance(getBalance() + amount);
        System.out.printf("Savings (%d) - You deposited $%.2f into your account%n", getAccountNumber(), getBalance());
    }

    @Override
    public void monthlyUpdate() {
        double monthlyRate = getInterestRate() / 12;
        setInterestRate( getBalance() * monthlyRate);
        super.setBalance(getBalance() + getInterestRate());
        accountUpdated = true;
    }

    @Override
    public void displaySummary() {
        System.out.printf("Savings (%d) - Balance: $%.2f%n", getAccountNumber(), getBalance());
        if(accountUpdated){
            System.out.printf("Interest applied: $%.2f%n", getInterestRate());
        }
    }
}
