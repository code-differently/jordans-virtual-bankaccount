package bank;

public class CreditAccount extends BankAccount {

    private final double creditLimit;

    private final double monthlyInterestRate;

    public CreditAccount(String owner, String accountNumber, double startingBalance,
                         double creditLimit, double monthlyInterestRate) {
        super(owner, accountNumber, startingBalance);

        this.creditLimit = creditLimit;

        this.monthlyInterestRate = monthlyInterestRate;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {

            System.out.println("Charge must be greater than 0.");

            return;
        }


        if ((balance - amount) < -creditLimit) {

            System.out.println("Charge denied: credit limit exceeded.");

            return;
        }

        balance -= amount;
    }

    @Override
    public void monthlyUpdate() {

        if (balance < 0) {

            balance += balance * monthlyInterestRate;

        }
    }

    @Override
    public String getAccountType() {
        return "Credit";
    }
}