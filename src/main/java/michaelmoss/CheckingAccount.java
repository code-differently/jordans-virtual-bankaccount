package michaelmoss;


// INHERITANCE: CheckingAccount extends BankAccount

public class CheckingAccount extends BankAccount {

    private static final double MONTHLY_FEE = 8;

    public CheckingAccount(String owner, String number, double balance) {
        super(owner, number, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= getBalance()) {
            setBalance(getBalance() - amount);
        }
    }

    // Monthly service fee
    @Override
    public void monthlyUpdate() {
        setBalance(getBalance() - MONTHLY_FEE);
    }
}