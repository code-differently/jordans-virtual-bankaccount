package org.codedifferently;

/*
 * Third account type: CreditAccount
 * - Balance represents amount owed
 * - Charges and payments handled differently
 */
public class CreditAccount extends BankAccount {

    private double creditLimit;
    private double interestRate = 0.03;
    private double lateFee = 15.00;

    public CreditAccount(String owner, String accountNumber, double balance, double creditLimit) {
        super(owner, accountNumber, balance);
        this.creditLimit = creditLimit;
    }

    @Override
    public void withdraw(double amount) { // charge
        if (amount > 0 && getBalance() + amount <= creditLimit) {
            setBalance(getBalance() + amount);
            addTransaction("Charge", amount, "Credit used");
        } else {
            System.out.println("Charge denied: credit limit exceeded.");
        }
    }

    @Override
    public void deposit(double amount) { // payment
        if (amount > 0) {
            setBalance(getBalance() - amount);
            addTransaction("Payment", amount, "Credit payment");
        }
    }

    @Override
    public void monthlyUpdate() {
        if (getBalance() > 0) {
            double interest = getBalance() * interestRate;
            setBalance(getBalance() + interest + lateFee);
            addTransaction("Monthly Update", interest + lateFee, "Interest + late fee applied");
        }
    }

    @Override
    public void printSummary() {
        System.out.println("Credit (" + getAccountNumber() + ") - Balance: $"
                + String.format("%.2f", getBalance()));
    }
}
