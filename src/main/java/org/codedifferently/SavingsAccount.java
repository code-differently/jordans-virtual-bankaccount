package org.codedifferently;

public class SavingsAccount extends BankAccount {

    public SavingsAccount(String ownerName, int accountNumber, double balance) {
        super(ownerName, accountNumber, balance);
    }

    @Override
    public double withdrawal(double amount){
        //if amount was greater what's result
        if(amount > super.getBalance()){
            return 0.0;
        }
        return amount;
    }

    @Override
    public void monthlyUpdate() {

    }

    @Override
    public void displaySummary() {
        System.out.printf("Checking (%d) - Balance: $%.2f%n", super.getAccountNumber(), super.getBalance());
    }
}
