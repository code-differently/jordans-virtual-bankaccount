package michaelmoss;

public class SavingsAccount extends BankAccount {

    private double interestRate = 0.02; // 2% monthly

    public SavingsAccount(String owner, String accountNumber, double balance) {
        super(owner, accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= getBalance()) {
            setBalance(getBalance() - amount);
        }
    }

    // Apply interest
    @Override
    public void monthlyUpdate() {
        double interest = getBalance() * interestRate;
        setBalance(getBalance() + interest);
    }
}