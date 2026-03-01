package org.codedifferently;

public class GrowthAccount extends BankAccount {

    private double growthRate;

    public GrowthAccount(String owner, String accountNumber,
                         double balance, double growthRate) {
        super(owner, accountNumber, balance);
        this.growthRate = growthRate;
    }

    //Polymorphism
    @Override
    public void monthlyUpdate() {
        double growth = getBalance() * (growthRate / 100);
        deposit(growth);
        addTransaction("Growth applied at " + growthRate + "%: $" + growth);
    }
}
