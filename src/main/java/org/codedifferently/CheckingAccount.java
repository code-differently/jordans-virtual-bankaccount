package org.codedifferently;
//child class of the BankAccount class
public class CheckingAccount extends BankAccount {
    //fields of a checking account
    private double minimumBalance;
    private boolean accountUpdated;

    //constructor
    public CheckingAccount(String ownerName, int accountNumber, double balance, double minimumBalance) {
        super(ownerName, accountNumber, balance);
        this.minimumBalance = minimumBalance;
        accountUpdated = false;
    }

    //getters and setters to access and modify private fields
    public double getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    //chunk of code below are methods that override the abstract methods in the parent class
    @Override
    public void deposit(double amount){
        setBalance(getBalance() + amount);
        System.out.printf("Checking (%d) - You deposited $%.2f into your account%n", getAccountNumber(), getBalance());
    }

    @Override
    public double withdrawal(double amount){
        //if amount was greater what's result
        if(amount > super.getBalance()){
            System.out.println("Checking (" + getAccountNumber() + ") - Transaction denied. Insufficient funds.");
            return 0.0;
        }
        setBalance(super.getBalance()-amount);

        System.out.printf("Checking (%d) - You withdrew $%.2f from your account%n", getAccountNumber(), amount);
        return amount;
    }

    @Override
    public void monthlyUpdate() {
        if(super.getBalance() < getMinimumBalance()){
            setBalance(getBalance()-20.00);
            accountUpdated = true;
        }
    }

    @Override
    public void displaySummary() {
        System.out.printf("Checking (%d) - Balance: $%.2f%n", getAccountNumber(), getBalance());
        if(accountUpdated){
            System.out.println("Below minimum balance: $20 fee applied.");
        }

    }
}
