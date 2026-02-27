package amanidrummond;


import java.text.DecimalFormat;

public abstract class BankAccount {
    private final String owner;
    private final String accountNumber;
    private double balance;

    protected static final DecimalFormat MONEY = new DecimalFormat("0.00");

    public BankAccount(String owner, String accountNumber, double startingBalance) {
        if (owner == null || owner.trim().isEmpty()) {
            throw new IllegalArgumentException("Owner name cannot be empty.");
        }
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Account number cannot be empty.");
        }
        this.owner = owner.trim();
        this.accountNumber = accountNumber.trim();
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

    protected void setBalance(double newBalance) {
        this.balance = newBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be greater than 0.");
        }
        setBalance(getBalance() + amount);
    }

    public abstract boolean withdraw(double amount);

    public abstract void monthlyUpdate();

    public abstract String getAccountType();

    public String getSummary() {
        return getAccountType() + " (" + accountNumber + ") - Balance: " + MONEY.format(balance);
    }

        }




