package mesheikbrown;

public class CheckingAccount extends BankAccount {

    private double minimumBalance;
    private double monthlyFee;


    public CheckingAccount(String owner,int accountNumber,double balance,double minimumBalance,double monthlyFee){
        super(owner, accountNumber, balance);
        this.minimumBalance = minimumBalance;
        this.monthlyFee = monthlyFee;
    }

    @Override
    public void monthlyUpdate() {

        // If balance is below the required minimum, charge the fee
        if (getBalance() < minimumBalance) {

            double newBalance = getBalance() - monthlyFee;

            // Safety rule: don't go below 0 (you can remove this if you want overdraft later)
            if (newBalance < 0) {
                newBalance = 0;
            }

            setBalance(newBalance);

            System.out.println("Monthly fee charged: " + monthlyFee);
            System.out.println("New balance: " + getBalance());
        } else {
            System.out.println("No monthly fee. Balance meets minimum.");
        }
    }

}// ends class


