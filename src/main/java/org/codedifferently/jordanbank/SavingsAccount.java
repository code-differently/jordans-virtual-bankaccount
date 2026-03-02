package org.codedifferently.jordanbank;


        // INHERITANCE
public class SavingsAccount extends BankAccount{

        // Unique field only savings has
        private double interestRate = 0.02; // 2% interest

        // Constructor
        public SavingsAccount(String owner, String accountNumber, double balance) {
            super(owner, accountNumber, balance);
        }

        // Withdraw cannot exceed balance
        @Override
        public void withdraw(double amount) {

            if (amount > 0 && amount <= balance) {
                balance -= amount;
            }
        }

        // Monthly update applies interest
        @Override
        public void monthlyUpdate() {

            // Interest formula
            balance += balance * interestRate;
        }
    }

