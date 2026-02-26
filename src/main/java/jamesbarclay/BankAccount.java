package jamesbarclay;

/*All accounts must:

Have an owner
Have an account number
Have a balance
Support deposits
Support withdrawals
Support a monthly update
Be able to print a summary
Base abstract class for all bank accounts
 Shows ABSTRACTION and ENCAPSULATION*/

public abstract class BankAccount {

    private String owner;
    private String accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String owner, String accountNumber, double balance) {
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Deposit works the same for all accounts
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Each account type must implement these
    public abstract void withdraw(double amount);
    public abstract void monthlyUpdate();
    public abstract void printSummary();

    // Protected so subclasses can use safely
    protected double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    protected String getAccountNumber() {
        return accountNumber;
    }

    protected String getOwner() {
        return owner;
    }
}