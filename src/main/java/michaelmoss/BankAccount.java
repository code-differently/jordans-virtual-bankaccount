package michaelmoss;


// Abstraction: This class defines common behavior for all accounts.
// Some behavior is abstract because different account types update differently.

public abstract class BankAccount {

    // Encapsulation: fields are private so they cannot be modified directly.
    private String owner;
    private String accountNumber;
    private double balance;

    public BankAccount(String owner, String accountNumber, double balance) {
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Getters (controlled access)
    public String getOwner() {
        return owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    // Protected so subclasses can adjust balance safely
    protected void setBalance(double balance) {
        this.balance = balance;
    }

    // Common behavior for all accounts
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Abstraction:
    // Each account withdraws differently, so subclasses must implement this.
    public abstract void withdraw(double amount);

    // Abstraction:
    // Monthly updates differ (fees, interest, etc.)
    public abstract void monthlyUpdate();

    // Shared method
    public void printSummary() {
        System.out.println("Owner: " + owner);
        System.out.println("Account #: " + accountNumber);
        System.out.println("Balance: $" + String.format("%.2f", balance));
        System.out.println("---------------------------");
    }
}