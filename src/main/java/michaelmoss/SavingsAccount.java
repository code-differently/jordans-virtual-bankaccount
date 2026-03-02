package michaelmoss;

public class SavingsAccount extends BankAccount {

    private static final double INTEREST_RATE = 0.015; // 1.5%

    public SavingsAccount(String owner, String number, double balance) {
        super(owner, number, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= getBalance()) {
            setBalance(getBalance() - amount);
        }
    }

    // Monthly interest added
    @Override
    public void monthlyUpdate() {
        double interest = getBalance() * INTEREST_RATE;
        setBalance(getBalance() + interest);
    }
}