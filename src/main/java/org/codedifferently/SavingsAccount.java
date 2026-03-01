package org.codedifferently;

/*
 * INHERITANCE:
 * SavingsAccount extends BankAccount.
 *
 * POLYMORPHISM:
 * It defines its own version of monthlyUpdate().
 */
public class SavingsAccount extends BankAccount {
    //Encapsulation
    private double interestRate;

    public SavingsAccount(String owner, String accountNumber,
                          double initialBalance, double interestRate) {
        super(owner, accountNumber, initialBalance);

        if (interestRate < 0) {
            throw new IllegalArgumentException("Interest rate has to be posititve.");
        }

        this.interestRate = interestRate;
    }

    @Override
    public void monthlyUpdate() {
        double interest = balance * interestRate;
        balance += interest;
    }

    @Override
    public void printSummary() {
        System.out.println(" Savings Account ");
        super.printSummary();
    }
}