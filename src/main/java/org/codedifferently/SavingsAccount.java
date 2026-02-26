package org.codedifferently;

public class SavingsAccount extends BankAccount {
    public SavingsAccount(double balance, String id, String owner) {
        super(balance, id ,owner);
    }

    @Override
    public void deposits(double deposit) {
        setBalance(getBalance()+deposit);

    }

    @Override
    public void withdraws(double withdraws) {

        if(withdraws > getBalance()){
            System.out.println("Action Cannot Be Completed, More than balance");
        }
        else{
            setBalance(getBalance()-withdraws);
        }

    }

    @Override
    public void monthlyFee() {

        double interest = getBalance() * .15;
        setBalance(getBalance() + interest);

    }

    @Override
    public void bankSummary() {
        System.out.println("Saving (" + getId() + ") - Balance " + getBalance() + " - Owner " + getOwner());
    }
}

