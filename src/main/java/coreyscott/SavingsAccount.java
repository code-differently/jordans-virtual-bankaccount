package coreyscott;

public class SavingsAccount extends BankAccount{

    private static final double INTEREST_RATE = 0.05;

    public SavingsAccount(String accountHolder, String accountNumber, double balance) {
        super(accountHolder, accountNumber, balance);
    }

    @Override
    public void monthlyUpdate() {
        balance += balance * INTEREST_RATE;
    }
}

