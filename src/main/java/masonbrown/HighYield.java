package masonbrown;

public class HighYield extends BankAccount {

    private double minimumBalance;

    public HighYield(String accountOwner, String accountNumber, double balance, double interestRate) {
        super(accountOwner, accountNumber, balance, interestRate);
        this.minimumBalance = 1000.00;
    }

    @Override
    public void monthlyUpdate() {

        System.out.println("\n==== High-Yield Monthly Update ====\n");
        System.out.println("Account Owner: " + accountOwner);
        System.out.println("Account Number: " + accountNumber);

        if (balance < minimumBalance) {
            System.out.println("Balance below high-yield minimum requirement.");
            System.out.println("$50.00 penalty fee deducted.");
            balance -= 50.00;
        }

        applyMonthlyInterest();

        System.out.println("Current Balance: " + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount < minimumBalance) {
            System.out.println("Withdrawal denied. Must maintain minimum balance of $" + minimumBalance);
        } else {
            balance -= amount;
            System.out.println("New Balance after withdrawal: " + balance);
        }
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("New Balance after deposit: " + balance);
    }
}
