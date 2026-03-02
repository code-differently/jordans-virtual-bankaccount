package org.codedifferently.jordanbank;

public class CheckingAccount extends BankAccount {
    // Constructor calls parent constructor using super()
    public CheckingAccount(String owner, String accountNumber, double balance) {
        super(owner, accountNumber, balance); // Reuse base logic
    }

    // Override withdraw behavior this is POLYMORPHISM
    @Override
    public void withdraw(double amount) {

        // Cannot withdraw more than balance
        if (amount > 0 && amount <= balance) {
            balance -= amount; // Subtract from balance
        }
    }

    // Monthly update applies fee if balance too low
    @Override
    public void monthlyUpdate() {

        // If balance under $500 apply $5 fee
        if (balance < 500) {
            balance -= 5;
        }
    }
}

