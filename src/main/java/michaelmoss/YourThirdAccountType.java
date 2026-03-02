package michaelmoss;

// Third account type: behaves differently (represents debt)

public class YourThirdAccountType extends BankAccount {

    private static final double INTEREST_RATE = 0.025; // 2.5%

    public YourThirdAccountType(String owner, String number, double balance) {
        super(owner, number, balance);
    }

    // Spending increases debt
    @Override
    public void withdraw(double amount) {
        if (amount > 0) {
            setBalance(getBalance() + amount);
        }
    }

    // Payment reduces debt
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            setBalance(getBalance() - amount);
        }
    }

    // Interest on debt
    @Override
    public void monthlyUpdate() {
        double interest = getBalance() * INTEREST_RATE;
        setBalance(getBalance() + interest);
    }
}