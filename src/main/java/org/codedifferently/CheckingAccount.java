package org.codedifferently;
public class CheckingAccount extends BankAccount {
    private double minimumBalance;

    public CheckingAccount(String ownerName, int accountNumber, double balance, double minimumBalance) {
        super(ownerName, accountNumber, balance);
        this.minimumBalance = minimumBalance;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    @Override
    public double withdrawal(double amount){
        //if amount was greater what's result
        if(amount > super.getBalance()){
            System.out.println("Transaction denied. Insufficient funds.");
            return 0.0;
        }
        setBalance(super.getBalance()-amount);
        return amount;
    }

    @Override
    public void monthlyUpdate() {
        if(super.getBalance() < getMinimumBalance()){
            setBalance(getBalance()-20.00);
        }
    }

    @Override
    public void displaySummary() {
        System.out.printf("Checking (%d) - Balance: $%.2f%n", super.getAccountNumber(), super.getBalance());
    }
}
