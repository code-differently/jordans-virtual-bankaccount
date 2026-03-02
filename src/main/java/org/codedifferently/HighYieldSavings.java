package org.codedifferently;

public class HighYieldSavings extends BaseAccount implements TransferFunds{
private double minimumBalance;
private double interestRate;
private int withdrawalsThisMonth;
//withdrawal limit should be 6
    private int withdrawalLimits;
private double bonusInterest;

public HighYieldSavings(String owner, int accountNumber, double accountBalance, double minimumBalance, double interestRate, int withdrawalsThisMonth, int withdrawalLimits, double bonusInterest){
  super(owner,accountNumber,accountBalance);
    this.minimumBalance = minimumBalance;
    this.interestRate = interestRate;
    this.withdrawalsThisMonth = withdrawalsThisMonth;
    this.withdrawalLimits = withdrawalLimits;
    this.bonusInterest = bonusInterest;

}
    @Override
    public void transfer(BaseAccount targetAccount, double amount) {

        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }

        double newBalance = getBalance() - amount;

        if (newBalance < minimumBalance) {
            System.out.println("Transfer denied. Minimum balance of $"
                    + minimumBalance + " must be maintained.");
            return;
        }

        adjustBalance(-amount);
        targetAccount.adjustBalance(amount);
        withdrawalsThisMonth++;

        System.out.println(
                "Transferred $" + amount +
                        " to account #" +
                        targetAccount.getAccountNumber());
    }
  @Override
  public void makeDeposit(double amount){
    adjustBalance(amount);
  }
    @Override
    public void makeWithdrawal(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }

        double newBalance = getBalance() - amount;

        if (newBalance < minimumBalance) {
            System.out.println("Withdrawal denied. Minimum balance of $"
                    + minimumBalance + " must be maintained.");
            return;
        }

        adjustBalance(-amount);
        withdrawalsThisMonth++;
    }
public void monthlyUpdate(){
    double monthlyInterest = getBalance() * (interestRate/12);
adjustBalance(monthlyInterest);
    //Bonus Interest condition
    if((getBalance() >= minimumBalance) && (withdrawalsThisMonth <= withdrawalLimits)){
adjustBalance(bonusInterest);
    }
    withdrawalsThisMonth = 0;
}


}
