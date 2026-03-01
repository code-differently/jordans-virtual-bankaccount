package org.codedifferently;

public class SavingsAccount extends BaseAccount implements TransferFunds {
    private double interestRate;

    public SavingsAccount(String owner, int accountNumber, double accountBalance, double interestRate) {
        super(owner, accountNumber, accountBalance);
        this.interestRate = interestRate;
    }

    @Override
    public void transfer(BaseAccount targetAccount, double amount) {

        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }

        if (getBalance() >= amount) {

            adjustBalance(-amount);
            targetAccount.adjustBalance(amount);

            System.out.println(
                    "Transferred $" + amount +
                            " to account #" +
                            targetAccount.getAccountNumber()
            );

        } else {
            System.out.println("Insufficient funds.");
        }
    }
        @Override
        public void makeWithdrawal (double amount){
            adjustBalance(-amount);
        }

        @Override
        public void makeDeposit (double amount){
            adjustBalance(amount);
        }


        public void monthlyUpdate () {
            double monthlyInterest = getBalance() * (interestRate / 12);
            adjustBalance(monthlyInterest);
        }


    }

