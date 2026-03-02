package coreyscott;

public abstract class BankAccount {
    // encapsulation
    private String accountHolder;
    private String accountNumber;
    protected double balance;

    public BankAccount(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Shared behavior
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

        // abstraction
        public abstract void monthlyUpdate ();

        public void printSummary () {
            System.out.printf("%s (%s) - Balance: $%.2f%n",
                    this.getClass().getSimpleName(),
                    accountNumber,
                    balance);
        }

        // Getters
        public String getAccountHolder () {
            return accountHolder;
        }

        public String getAccountNumber () {
            return accountNumber;
        }

        public double getBalance () {
            return balance;
        }
    }




