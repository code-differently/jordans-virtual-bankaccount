package amanidrummond;

public class CheckingAccount extends BankAccount {
    private final double minimumBalance;
    private final double monthlyFee;

    public CheckingAccount(String owner, String accountNumber, double startingBalance,
                           double minimumBalance, double monthlyFee) {
        super(owner, accountNumber, startingBalance);
        this.minimumBalance = minimumBalance;
        this.monthlyFee = monthlyFee;

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
        if (getBalance() < minimumBalance) {
            setBalance(getBalance() - monthlyFee);

        }
    }

        @Override
        public String getAccountType () {
            return "Checking";
        }
        }


