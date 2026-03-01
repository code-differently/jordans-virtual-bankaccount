package mesheikbrown;

public class InvestmentAccount extends BankAccount{
    private double monthlyGrowthRate;
    private double withdrawalPenaltyRate;

    public InvestmentAccount(String owner,int accountNumber,double balance,double monthlyGrowthRate,double withdrawalPenaltyRate){
        super(owner, accountNumber, balance);
        this.monthlyGrowthRate = monthlyGrowthRate;
        this.withdrawalPenaltyRate = withdrawalPenaltyRate;
    }

    @Override
    public void withdraw(double amount) {

        if (amount > 0 && amount <= getBalance()) {

            double penalty = amount * withdrawalPenaltyRate;
            double totalWithdrawal = amount + penalty;

            if (totalWithdrawal <= getBalance()) {
                setBalance(getBalance() - totalWithdrawal);

                System.out.println("Withdrawal: " + amount);
                System.out.println("Penalty: " + penalty);
                System.out.println("New balance: " + getBalance());
            } else {
                System.out.println("Not enough funds including penalty.");
            }

        } else {
            System.out.println("Invalid withdrawal.");
        }
    }

    @Override
    public void monthlyUpdate() {

        double growth = getBalance() * monthlyGrowthRate;

        setBalance(getBalance() + growth);

        System.out.println("Investment growth added: " + growth);
        System.out.println("New balance: " + getBalance());
    }
}// ends class
