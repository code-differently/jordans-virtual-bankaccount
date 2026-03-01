package mesheikbrown;

public class SavingsAccount extends BankAccount{
    private double interestRate;

    public SavingsAccount(String owner,int accountNumber,double balance,double interestRate){
        super(owner, accountNumber, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void monthlyUpdate() {

        // Calculate interest earned
        double interest = getBalance() * interestRate;

        // Add interest to balance
        double newBalance = getBalance() + interest;

        setBalance(newBalance);

        System.out.println("Interest added: " + interest);
        System.out.println("New balance: " + getBalance());
    }
}//ends class

