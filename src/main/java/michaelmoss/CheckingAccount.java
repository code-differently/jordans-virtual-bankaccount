package michaelmoss;


// Inheritance: CheckingAccount reuses BankAccount fields and methods.

public class CheckingAccount extends BankAccount {

    private double minimumBalance = 100;
    private double lowBalanceFee = 10;

    public CheckingAccount(String owner, String accountNumber, double balance) {
        super(owner, accountNumber, balance);
    }

    // Cannot withdraw more than balance
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= getBalance()) {
            setBalance(getBalance() - amount);
        }
    }

    // Monthly fee if balance is too low
    @Override
    public void monthlyUpdate() {
        if (getBalance() < minimumBalance) {
            setBalance(getBalance() - lowBalanceFee);
        }
    }
}