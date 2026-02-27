package masonbrown;

public class SavingsAccount extends BankAccount {

    public SavingsAccount(String accountOwner, String accountNumber, double balance, double interestRate) {

        super(accountOwner, accountNumber, balance, interestRate);
    }
    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("New Balance after withdrawal: " + balance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }
    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("New Balance after deposit: " + balance);
    }

    @Override
    public void monthlyUpdate() {

        System.out.println("\n==== Monthly Update ====\n");
        System.out.println("Account Owner: " + accountOwner);
        System.out.println("Account Number: " + accountNumber);

        if (balance < 50) {
            System.out.println("Balance below minimum to maintain account.");
            System.out.println("$35.00 maintenance fee deducted ");
            balance -= 35;  // <-- YOU WERE MISSING THIS
        }

        applyMonthlyInterest();

        System.out.println("Current Balance: " + balance);
    }
    }
