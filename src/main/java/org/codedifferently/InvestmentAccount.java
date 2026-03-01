package org.codedifferently;

import java.util.Random;

/*INHERITANCE:Extends BankAccount.
 *POLYMORPHISM:Overrides both withdraw() and monthlyUpdate().
 */
public class InvestmentAccount extends BankAccount {
    //Encapsulation
    private static final double WITHDRAWAL_FEE = 10.00;
    private static final double MAX_VARIATION = 0.05;

    private Random random = new Random();

    //Constructor
    public InvestmentAccount(String owner, String accountNumber,
                             double initialBalance) {
        super(owner, accountNumber, initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        double total = amount + WITHDRAWAL_FEE;
        super.withdraw(total);
    }

    @Override
    public void monthlyUpdate() {
        double percentChange =
                (random.nextDouble() * 2 * MAX_VARIATION) - MAX_VARIATION;

        balance += balance * percentChange;
    }

    @Override
    public void printSummary() {
        System.out.println(" Investment Account ");
        super.printSummary();
    }
}