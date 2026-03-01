package mesheikbrown;

public abstract class BankAccount {
    //Variables
    private String owner;
    private int accountNumber;
    private double balance;

    // This runs when a new BankAccount (or child account) is created.
    public BankAccount(String owner,int accountNumber,double balance) {
        //Constructor
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = balance;

    }

    // Getters allow us to READ the values safely.
    public String getOwner() {
        return owner;
    }
    public int getAccountNumber() {
        return accountNumber;
    }
    public double getBalance() {
        return balance;
    }

    // Setters allow us to change certain values.
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    // We make this protected so only this class
    protected void setBalance(double balance) {
        this.balance = balance;
    }
    // This adds money to the account.
    public void deposit(double amount) {
        if (amount > 0) {

            // Add money to balance
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Amount must be greater than 0.");
        }
    }
    // This removes money from the account.
    public void withdraw(double amount) {
        // We check:
        // 1. The amount is positive
        // 2. We have enough money
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal.");
        }
    }

    // Child classes MUST implement these
    public abstract void monthlyUpdate();

    public void printSummary() {
        System.out.println("Owner: " + owner);
        System.out.println("Account #: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}// ends class
