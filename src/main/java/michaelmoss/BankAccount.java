package michaelmoss;


// ABSTRACTION:
// This abstract class defines what ALL accounts have in common.
// Subclasses must implement withdraw() and monthlyUpdate()
// because each account behaves differently.

public abstract class BankAccount {

    // ENCAPSULATION:
    // Fields are private to protect data.
    // They cannot be changed directly from outside the class.
    private String owner;
    private String accountNumber;
    private double balance;

    public BankAccount(String owner, String accountNumber, double balance) {
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    // Protected so subclasses can safely modify balance
    protected void setBalance(double balance) {
        this.balance = balance;
    }

    // Common behavior for all accounts
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // ABSTRACT METHODS:
    // Different account types handle these differently.
    public abstract void withdraw(double amount);
    public abstract void monthlyUpdate();

    public void printSummary() {
        System.out.printf("%s (%s) - Balance: $%.2f\n",
                this.getClass().getSimpleName().replace("Account", ""),
                accountNumber,
                balance);
    }
}