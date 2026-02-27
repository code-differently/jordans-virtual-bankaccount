package masonbrown;

public class CheckingAccount extends BankAccount {


    public CheckingAccount(String accountOwner, String accountNumber, double balance, double interestRate) {

        super(accountOwner, accountNumber, balance, interestRate);

    }
    @Override
    public void monthlyUpdate() {

        System.out.println("\n==== Monthly Update ====\n");
        System.out.println("Account Owner: " + accountOwner);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: " + balance);

    }
    // Deposit money
    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("New Balance after deposit: " + balance);
    }


    // Withdraw money
    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("New Balance after withdrawal: " + balance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

}