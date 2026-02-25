package org.codedifferently;

public class CheckingAccount extends BankAccount {


    public CheckingAccount(String owner, int accountNumber, double balance) {
        super(owner, accountNumber, balance);
    }

    @Override
    public void monthlyUpdate(){
        if(balance < 100 && balance > 5){
            System.out.println("A fee of $5 has been charged to your account this month, as your balance is below $100");
            withdrawal(5);
        }else if(balance < 5){
            System.out.println("Your account is at risk of being closed due to insufficient funds.");
        }

        //add prints

       super.monthlyUpdate();
        System.out.println("Checking (" + accountNumber + ") - Balance: " + balance);

    }

    //monthly update, print out a summary of what the account is doing after it's already done



}
