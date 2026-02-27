package coreyscott;

public class CheckingAccount extends BankAccount {
    //Account rules:
    //Minimum balance of $100
    //Monthly fee of $10
    private static final double MIN_BALANCE = 100;
    private static final double MONTHLY_FEE = 10;

    public CheckingAccount(String accountHolder, String accountNumber, double balance){
            super(accountHolder, accountNumber, balance);
    }

    @Override
    public void monthlyUpdate() {
        if (balance < MIN_BALANCE) {
            balance -= MONTHLY_FEE;
        }

    }



}
