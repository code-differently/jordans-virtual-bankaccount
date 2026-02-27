package jamesbarclay;

// Savings account earns interest

public class SavingAccount extends BankAccount  {

    public SavingAccount(String owner, String accountNumber, double balance) {
        super(owner, accountNumber, balance);
    }

    @Override
    public void withdraw(double amount)  {

        if (amount <= getBalance()) {
            setBalance(getBalance() - amount);
        } else {
            System.out.println("Savings: Not enough funds.");
        }
    }

    @Override
    public void monthlyUpdate() {
        // add 2% interest
        double interest = getBalance() * 0.02;
        setBalance(getBalance() + interest);
    }

    @Override
    public void printSummary() {
        System.out.println(
                "Savings (" + getAccountNumber() + ") - Balance: $" +
                        String.format("%.2f", getBalance())
        );
    }
}