package org.codedifferently;

public class CreditAccount extends BankAccount {

    private final double interestRate;
    private final double maxBalance;


    private double statementBalance;
    private double minPaymentDue;
    private double paymentsThisCycle;

    private static final double MIN_PAYMENT_RATE = 0.10;
    private static final double PENALTY_RATE = 0.30;

    public CreditAccount(String owner, int accountNumber, double balance, double interestRate, double maxBalance) {
        super(owner, accountNumber, balance);
        this.interestRate = interestRate;
        this.maxBalance = maxBalance;

        this.statementBalance = balance;
        this.minPaymentDue = round2(this.statementBalance * MIN_PAYMENT_RATE);
        this.paymentsThisCycle = 0.0;
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Payment must be positive.");
            return;
        }

        System.out.println("You paid $" + round2(amount));

        double before = balance;
        balance -= amount;
        if (balance < 0) balance = 0;

        double applied = before - balance;
        paymentsThisCycle += applied;
    }

    @Override
    public void withdrawal(double amount) {
        if (amount <= 0) {
            System.out.println("Charge must be positive.");
            return;
        }

        System.out.println("You charged $" + round2(amount) + " to credit");

        if (balance + amount <= maxBalance) {
            balance += amount;
        } else {
            System.out.println("Declined: charge would exceed credit limit of $" + round2(maxBalance));
        }
    }

    @Override
    public void monthlyUpdate() {
        System.out.println("\n---- BILLING CYCLE ---");
        System.out.println("Statement balance (last month): $" + round2(statementBalance));
        System.out.println("Current balance (before interest): $" + round2(balance));
        System.out.println("Minimum payment due this cycle: $" + round2(minPaymentDue));
        System.out.println("Payments made this cycle: $" + round2(paymentsThisCycle));

        if (statementBalance > 0) {
            boolean missedMin = (minPaymentDue > 0) && (paymentsThisCycle + 1e-9 < minPaymentDue);

            if (missedMin) {
                System.out.println("You failed to pay the minimum payment.");
                double interest = statementBalance * PENALTY_RATE;
                System.out.println("Penalty interest charged (30% of $" + round2(statementBalance) + "): $" + round2(interest));
                balance += interest;
            } else {
                double interest = statementBalance * (interestRate / 100.0);
                System.out.println("Regular interest charged (" + round2(interestRate) + "% of $" + round2(statementBalance) + "): $" + round2(interest));
                balance += interest;
            }
        }

        statementBalance = balance;
        minPaymentDue = round2(statementBalance * MIN_PAYMENT_RATE);
        paymentsThisCycle = 0.0;

        System.out.println("\nEnd of cycle / New statement:");
        System.out.println("New balance: $" + round2(balance));
        System.out.println("New statement balance: $" + round2(statementBalance));
        System.out.println("New minimum payment due next cycle: $" + round2(minPaymentDue));
    }

    @Override
    public void printSummary() {
        System.out.println(
                "Credit (" + accountNumber + ") - Balance: $" + round2(balance)
                        + " | Statement Balance: $" + round2(statementBalance)
                        + " | Min Due: $" + round2(minPaymentDue)
                        + " | Paid This Cycle: $" + round2(paymentsThisCycle)
                        + " | Limit: $" + round2(maxBalance)
        );
    }

    private double round2(double x) {
        return Math.round(x * 100.0) / 100.0;
    }
}