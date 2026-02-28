package org.codedifferently;

public abstract class BaseAccount {
    private String owner;
    private int accountNumber;
    private double balance;

    public BaseAccount(String owner, int accountNumber, double balance) {
   this.accountNumber = accountNumber;
   this.owner = owner;
   this.balance = balance;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
protected void adjustBalance(double amount){
balance += amount;
}

public abstract void makeWithdrawal(double amount);

    public abstract void makeDeposit(double amount);

public void accountSummary(){
    System.out.println("Account owner: "+ owner );
    System.out.println("Account number: " + accountNumber);
    System.out.println("Current balance: " + balance);
}

public void monthlyUpdate() {

}
}
