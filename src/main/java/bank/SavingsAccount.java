package bank;

public class SavingsAccount extends BankAccount {

    private final double monthlyInterestRate; // example: 0.02 for 2%

    public SavingsAccount(String owner, String accountNumber, double startingBalance, double monthlyInterestRate) {
        super(owner, accountNumber, startingBalance);

        this.monthlyInterestRate = monthlyInterestRate;

    }

    @Override
    public void monthlyUpdate() {

        if (balance > 0) {

            balance += balance * monthlyInterestRate;
        }
    }

    @Override
    public String getAccountType() {

        return "Savings";

    }
}