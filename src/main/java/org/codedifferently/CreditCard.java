package org.codedifferently;

public class CreditCard extends BankAccount{


    private double creditLimit;



    public CreditCard(double balance, String id, String owner, double creditLimit) {
        super(balance, id, owner);
        this.creditLimit = creditLimit;

           }

    @Override
    public void deposits(double deposit) {
        if(deposit > getBalance()){
            deposit = getBalance();
        }

        setBalance(getBalance() + deposit); // you owe less

    }

    @Override
    public void withdraws(double withdraws) {
        if(withdraws <= getBalance()){
            setBalance(getBalance() - withdraws); // you owe more
        } else {
            System.out.println("Declined: Not enough credit.");
        }
    }

    @Override
    public void monthlyFee() {
       if(getBalance() < 0) {
           double interest = getBalance() * 0.03;
           setBalance(getBalance() - interest);
       }
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public double debt(){

        return getCreditLimit() - getBalance();

    }

    @Override
    public void bankSummary() {

        System.out.printf("Credit (" + getId() + ") - Balance: "+ getBalance() + " - Owner " + getOwner());
    }



}
