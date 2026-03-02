package michaelmoss;

public class YourThirdAccountType extends BankAccount {

    private double creditLimit = -1000;
    private double interestRate = 0.03; // 3% monthly on debt

    public YourThirdAccountType(String owner, String accountNumber, double balance) {
        super(owner, accountNumber, balance);
    }

    // Withdraw = spending (can go negative up to limit)
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (getBalance() - amount) >= creditLimit) {
            setBalance(getBalance() - amount);
        }
    }

    // Monthly interest if balance is negative
    @Override
    public void monthlyUpdate() {
        if (getBalance() < 0) {
            double interest = getBalance() * interestRate;
            setBalance(getBalance() + interest);
        }
    }
}