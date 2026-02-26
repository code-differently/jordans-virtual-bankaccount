package org.codedifferently;
public class CheckingAccount extends BankAccount {

    public CheckingAccount(String ownerName, int accountNumber, double balance) {
        super(ownerName, accountNumber, balance);
    }

    @Override
    public void deposit(double amount){
        super.setBalance(super.getBalance() + amount);
    }



}
