package bank;

public class CheckingAccount extends BankAccount {

    private final double lowBalanceFee;

    private final double lowBalanceThreshold;

    public CheckingAccount(String owner, String accountNumber, double startingBalance,
                           double lowBalanceThreshold, double lowBalanceFee) {

        super(owner, accountNumber, startingBalance);

        this.lowBalanceThreshold = lowBalanceThreshold;

        this.lowBalanceFee = lowBalanceFee;
    }

    @Override
    public void monthlyUpdate() {

        if (balance < lowBalanceThreshold) {

            balance -= lowBalanceFee;

        }
    }

    @Override
    public String getAccountType() {

        return "Checking";

    }
}