package org.codedifferently;

public class Checking extends BaseAccount {
    private static final double LOW_BALANCE_FEE = 10.00;
    private static final double LOW_BALANCE_THRESHOLD = 100.00;

    public Checking(String owner, String accountNumber, double initialBalance) {
        super(owner, accountNumber, initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Cannot withdraw more than the balance.");
        } else {
            super.withdraw(amount);
        }
    }

    @Override
    public void monthlyUpdate() {
        if (balance < LOW_BALANCE_THRESHOLD) {
            balance -= LOW_BALANCE_FEE;
            System.out.println("Low balance fee applied: " + LOW_BALANCE_FEE);
        }
    }
}