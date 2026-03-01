package org.codedifferently;

public class CheckingAccount extends BaseAccount implements TransferFunds{
    private double updateFee;
    public CheckingAccount(String owner, int accountNumber, double balance, double updateFee) {
super(owner, accountNumber, balance);
   this.updateFee = updateFee;
    }
    @Override
    public void transfer(BaseAccount targetAccount, double amount) {

        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }

        if (getBalance() >= amount) {

            adjustBalance(-amount);
            targetAccount.adjustBalance(amount);

            System.out.println(
                    "Transferred $" + amount +
                            " to account #" +
                            targetAccount.getAccountNumber()
            );

        } else {
            System.out.println("Insufficient funds.");
        }
    }
    @Override
    public void makeWithdrawal(double amount) {
if(amount > getBalance()){
    System.out.println("Are you serious? You don't have enough funds to withdrawal that amount Jordan. " +
            "You only have: " + getBalance());
}
else{adjustBalance(-amount);}

    }


   @Override
    public void makeDeposit(double amount){
adjustBalance(amount);
    }

    public void monthlyUpdate() {
   if (getBalance() < 20){
       adjustBalance(-updateFee);
   }
    }
}
