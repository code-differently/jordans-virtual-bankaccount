package masonbrown;

public abstract class BankAccount {

    protected String accountOwner;
    protected String accountNumber;
    protected double balance;
    protected double interestRate;

    public BankAccount(String accountOwner, String accountNumber, double balance, double interestRate) {
        this.accountOwner = accountOwner;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.interestRate = interestRate;
    }



    // Calculate monthly interest
    public double calculateMonthlyInterest() {
        double interestAccrued = balance * (interestRate / 12);
        System.out.println("Interest Accrued: " + interestAccrued);
        return interestAccrued;
    }

    // Apply monthly interest to balance
    public void applyMonthlyInterest() {
        double interestAccrued = calculateMonthlyInterest();
        balance += interestAccrued;
    }

    // Deposit money
    public void deposit(double amount) {
        balance += amount;
        System.out.println("New Balance after deposit: " + balance);
    }

    // Withdraw money
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("New Balance after withdrawal: " + balance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    // Monthly summary
    public void monthlyUpdate() {
        System.out.println("\n==== Monthly Update ====\n");
        System.out.println("Account Owner: " + accountOwner);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: " + balance);
    }
}