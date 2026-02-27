package jamesbarclay;

// Checking account
// Charges small fee if balance is low

public class CheckingAccount extends BankAccount {

    public CheckingAccount(String owner, String accountNumber, double balance) {
        super(owner, accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) {

        if (amount <= getBalance()) {
            setBalance(getBalance() - amount);
        } else {
            System.out.println("Checking: Not enough funds.");
        }
    }

    @Override
    public void monthlyUpdate() {
        // simple rule: fee if under $100
        if (getBalance() < 100) {
            setBalance(getBalance() - 5);
        }
    }

    @Override
    public void printSummary() {
        System.out.println(
                "Checking (" + getAccountNumber() + ") - Balance: $" +
                        String.format("%.2f", getBalance())
        );
    }
}