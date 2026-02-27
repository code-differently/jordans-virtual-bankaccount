package jamesbarclay;

// Custom account with monthly spending limit

public class SpendingAccount extends BankAccount {

    private double monthlyLimit;
    private double spentThisMonth;

    public SpendingAccount(String owner, String accountNumber,
                           double balance, double monthlyLimit) {
        super(owner, accountNumber, balance);
        this.monthlyLimit = monthlyLimit;
        this.spentThisMonth = 0;
    }

    @Override
    public void withdraw(double amount)  {

        if (amount > getBalance()) {
            System.out.println("Spending: Not enough funds.");
            return;
        }

        if (spentThisMonth + amount > monthlyLimit) {
            System.out.println("Spending: Monthly limit reached.");
            return;
        }

        setBalance(getBalance() - amount);
        spentThisMonth += amount;
    }

    @Override
    public void monthlyUpdate() {
        // reset each month
        spentThisMonth = 0;
    }

    @Override
    public void printSummary() {
        System.out.println(
                "Spending (" + getAccountNumber() + ") - Balance: $" +
                        String.format("%.2f", getBalance())
        );
    }
}