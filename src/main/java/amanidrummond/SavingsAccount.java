package amanidrummond;

public class SavingsAccount extends BankAccount {

    private final double monthlyInterestRate;

    public SavingsAccount(String owner, String accountNumber, double startingBalance,
                          double monthlyInterestRate) {
        super(owner, accountNumber, startingBalance);
        this.monthlyInterestRate = monthlyInterestRate;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            return false;
        }
        if (amount > getBalance()) {
            return false;
        }
            setBalance(getBalance() - amount);
            return true;
        }


    @Override
    public void monthlyUpdate() {
        if (getBalance() > 0) {
            double interest = getBalance() * monthlyInterestRate;
            setBalance(getBalance() + interest);

        }
        }
        @Override
        public String getAccountType() {
            return "Savings";
        }
    }








