package amanidrummond;

public class CreditAccount extends BankAccount {
    private final double creditLimit;
    private final double monthlyInterestRate;

    public CreditAccount(String owner, String accountNumber, double startingBalance,
                         double creditLimit, double monthlyInterestRate) {
        super(owner,accountNumber,startingBalance);
        this.creditLimit = creditLimit;
        this.monthlyInterestRate = monthlyInterestRate;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0){
            return false;
        }
        double newBalance = getBalance() - amount;

        if (newBalance < -creditLimit) {
            return false;
        }  setBalance(newBalance);
        return true;
            }

            @Override
    public void monthlyUpdate() {
        if (getBalance() < 0) {
            double interestCharge = Math.abs(getBalance()) * monthlyInterestRate;
            setBalance(getBalance() - interestCharge);
        }
            }

            @Override
    public String getAccountType() {
        return "Credit";
            }
        }

