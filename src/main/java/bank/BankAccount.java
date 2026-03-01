package bank;

public abstract class BankAccount {


    private final String owner;

    private final String accountNumber;

    protected double balance;

    public BankAccount(String owner, String accountNumber, double startingBalance) {
        this.owner = owner;

        this.accountNumber = accountNumber;

        this.balance = startingBalance;
    }

    public String getOwner() {
        return owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }


    public void deposit(double amount) {
        if (amount <= 0) {

            System.out.println("Deposit must be greater than 0.");

            return;
        }
        balance += amount;
    }


    public void withdraw(double amount) {
        if (amount <= 0) {

            System.out.println("Withdrawal must be greater than 0.");

            return;
        }
        if (amount > balance) {

            System.out.println("Insufficient funds.");

            return;
        }
        balance -= amount;
    }


    public abstract void monthlyUpdate();

    public String getSummary() {

        return getAccountType() + " (" + accountNumber + ") - Balance: $" + String.format("%.2f", balance);
    }


    public abstract String getAccountType();
}