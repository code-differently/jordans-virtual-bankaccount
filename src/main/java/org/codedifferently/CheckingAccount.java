package org.codedifferently;

/*
 * INHERITANCE:
 * CheckingAccount reuses deposit and withdraw from BankAccount.
 *
 * POLYMORPHISM:
 * It overrides monthlyUpdate() with its own specific behavior.
 */

public class CheckingAccount extends BankAccount {
//Encapsulation
    private static final double MIN_BALANCE = 500.00;
    private static final double LOW_BALANCE_FEE = 25.00;
    //Constructor
    public CheckingAccount(String owner, String accountNumber, double initialBalance) {
        super(owner, accountNumber, initialBalance);
    }

    @Override
    public void monthlyUpdate() {
        if (balance < MIN_BALANCE) {
            balance -= LOW_BALANCE_FEE;
        }
    }

    @Override
    public void printSummary() {
        System.out.println(" Checking Account ");
        super.printSummary();
    }
}